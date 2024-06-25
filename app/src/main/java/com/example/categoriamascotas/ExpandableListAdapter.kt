package com.example.categoriamascotas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView

class ExpandableListAdapter(
    private val context: Context,
    private val listDataHeader: List<String>,
    private val listDataChild: HashMap<String, List<String>>,
    private val listDataHeaderImages: List<Int>
) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return this.listDataChild[this.listDataHeader[groupPosition]]!![childPosition]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val childText = getChild(groupPosition, childPosition) as String

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_item, null)
        }

        val txtListChild = convertView!!.findViewById<TextView>(R.id.ListItem)
        txtListChild.text = childText
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.listDataChild[this.listDataHeader[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return this.listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return this.listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        val headerImage = listDataHeaderImages[groupPosition]

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_grup, null)
        }

        val lblListHeader = convertView!!.findViewById<TextView>(R.id.lblListHeader)
        val imgListHeader = convertView.findViewById<ImageView>(R.id.imgListHeader)
        lblListHeader.setTypeface(null, android.graphics.Typeface.BOLD)
        lblListHeader.text = headerTitle
        imgListHeader.setImageResource(headerImage)

        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}

