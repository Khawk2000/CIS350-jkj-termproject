package com.example.homework_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem; // used to help with expanding list
import com.diegodobelo.expandingview.ExpandingList;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    public ExpandingList mExpandingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandingList = findViewById(R.id.expanding_list_main);
        createItems();
    }

    private void createItems() {
        addItem("Class 1", new String[]{"H: APP", "H:IN CLASS LAB", "M: TESTING", "M:PARTNERS REVIEW"}, R.color.pink);
        addItem("Class 2", new String[]{"H: GROUP PROJECT", "H:VIDEO PRESENTATION", "M: HW4"}, R.color.blue);
        addItem("Class 3", new String[]{"H: APPLY FOR JOBS"}, R.color.purple);
        addItem("Class 4", new String[]{"M: STUDY FOR FINAL"}, R.color.green);
        addItem("Class 5", new String[]{"M: GROUP PROJECT", "M: HW 7"}, R.color.orange);
 }

    private void addItem(String title, String[] subItems, int colorRes) {
        //Let's create an item with R.layout.expanding_layout
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.expanding_layout);

        //If item creation is successful, let's configure it
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            ((TextView) item.findViewById(R.id.title)).setText(title);

            //We can create items in batch.
            item.createSubItems(subItems.length);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                //Let's get the created sub item by its index
                final View view = item.getSubItemView(i);

                //Let's set some values in
                configureSubItem(item, view, subItems[i]);
            }
            item.findViewById(R.id.add_more_sub_items).setOnClickListener(v -> showInsertDialog(title1 -> {
                View newSubItem = item.createSubItem();
                configureSubItem(item, newSubItem, title1);
            }));

            item.findViewById(R.id.remove_item).setOnClickListener(v -> mExpandingList.removeItem(item));
        }
    }

    private void configureSubItem(final ExpandingItem item, final View view, String subTitle) {
        ((TextView) view.findViewById(R.id.sub_title)).setText(subTitle);
        view.findViewById(R.id.remove_sub_item).setOnClickListener(v -> item.removeSubItem(view));
    }

    private void showInsertDialog(final OnItemCreated positive) {
        final EditText text = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(text);
        builder.setTitle(R.string.enter_title);
        builder.setPositiveButton(android.R.string.ok, (dialog, which) -> positive.itemCreated(text.getText().toString()));
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }

    interface OnItemCreated {
        void itemCreated(String title);
    }
}