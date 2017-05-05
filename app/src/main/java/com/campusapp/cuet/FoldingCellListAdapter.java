package com.campusapp.cuet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;


import java.util.HashSet;
import java.util.List;

import agency.tango.materialintro.R;
//TODO 2: In Order To Add Or Remove Modify In This Funtion After Modifying The XML


/*
*This Is The Adapter For the List View In Geek Section. Every ListView Needs a Adapter. The Adapter Handles
* The Data and the Layout of the List.
 */
public class FoldingCellListAdapter extends ArrayAdapter<Item> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;


    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get item for selected view
        Item item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.department = (TextView) cell.findViewById(R.id.department);
            viewHolder.time = (TextView) cell.findViewById(R.id.title_time_label);
            viewHolder.date = (TextView) cell.findViewById(R.id.title_date_label);
            viewHolder.shortName = (TextView) cell.findViewById(R.id.short_name);
            viewHolder.fullName=(TextView) cell.findViewById(R.id.full_name);
            viewHolder.universityId=(TextView) cell.findViewById(R.id.university_id);
            viewHolder.contactInfo=(TextView) cell.findViewById(R.id.contact_info);

            //To add Things Inside list Add Here

            viewHolder.interests = (TextView) cell.findViewById(R.id.interests);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        // bind data from selected element to view through view holder
        viewHolder.department.setText(item.getDepartment());
        viewHolder.time.setText(item.getTime());
        viewHolder.date.setText(item.getDate());
        //To add Things Inside List Add Here

        viewHolder.shortName.setText(item.getShortName());
        viewHolder.interests.setText(item.getInterests());
        viewHolder.fullName.setText(item.getFullName());
        viewHolder.universityId.setText(item.getUniversityId());
        viewHolder.contactInfo.setText(item.getContactInfo());

        viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);


        // set custom btn handler for list item from that item
        if (item.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }


        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView department;
        TextView contentRequestBtn;
        TextView shortName;
        //To add Things Inside List Add Here

        TextView interests;
        TextView fullName;
        TextView universityId;
        TextView contactInfo;

        TextView date;
        TextView time;
    }
}
