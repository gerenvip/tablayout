package com.gerenvip.ui.samples

import android.R
import android.app.ListActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import java.text.Collator
import java.util.*

private const val CATEGORY_SAMPLE_CODE = Intent.CATEGORY_SAMPLE_CODE + "_ww"

class MainActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        var path: String? = intent.getStringExtra("com.example.android.apis.Path")

        if (path == null) {
            path = ""
        }
        listAdapter = SimpleAdapter(
                this, getData(path),
                R.layout.simple_list_item_1, arrayOf("title"),
                intArrayOf(R.id.text1)
        )
        listView.isTextFilterEnabled = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val result = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if (PackageManager.PERMISSION_GRANTED == result) {
                return
            }
            requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
        }
    }
    private fun getData(prefix: String): List<Map<String, Any>> {
        val myData = ArrayList<Map<String, Any>>()

        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(CATEGORY_SAMPLE_CODE)

        val pm = packageManager
        val list = pm.queryIntentActivities(mainIntent, 0) ?: return myData

        val prefixPath: Array<String>?
        var prefixWithSlash = prefix

        if (prefix == "") {
            prefixPath = null
        } else {
            prefixPath = prefix.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            prefixWithSlash = "$prefix/"
        }

        val len = list.size

        val entries = HashMap<String, Boolean>()

        for (i in 0 until len) {
            val info = list[i]
            val labelSeq = info.loadLabel(pm)
            val label = labelSeq?.toString() ?: info.activityInfo.name

            if (prefixWithSlash.isEmpty() || label.startsWith(prefixWithSlash)) {

                val labelPath = label.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                val nextLabel = if (prefixPath == null) labelPath[0] else labelPath[prefixPath.size]

                if (prefixPath?.size ?: 0 == labelPath.size - 1) {
                    addItem(
                            myData, nextLabel, activityIntent(
                            info.activityInfo.applicationInfo.packageName,
                            info.activityInfo.name
                    )
                    )
                } else {
                    if (entries[nextLabel] == null) {
                        addItem(myData, nextLabel, browseIntent(if (prefix == "") nextLabel else "$prefix/$nextLabel"))
                        entries[nextLabel] = true
                    }
                }
            }
        }

        Collections.sort(myData, sDisplayNameComparator)
        return myData
    }

    private fun browseIntent(path: String): Intent {
        val result = Intent()
        result.setClass(this, MainActivity::class.java)
        result.putExtra("com.example.android.apis.Path", path)
        return result
    }

    private fun addItem(data: MutableList<Map<String, Any>>, name: String, intent: Intent) {
        val temp = HashMap<String, Any>()
        temp["title"] = name
        temp["intent"] = intent
        data.add(temp)
    }

    private fun activityIntent(pkg: String, componentName: String): Intent {
        val result = Intent()
        result.setClassName(pkg, componentName)
        return result
    }

    private val sDisplayNameComparator = object : Comparator<Map<String, Any>> {
        private val collator = Collator.getInstance()

        override fun compare(map1: Map<String, Any>, map2: Map<String, Any>): Int {
            return collator.compare(map1["title"], map2["title"])
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        val map = l.getItemAtPosition(position) as Map<String, Any>

        val intent = Intent(map["intent"] as Intent?)
        intent.addCategory(CATEGORY_SAMPLE_CODE)
        startActivity(intent)
    }
}
