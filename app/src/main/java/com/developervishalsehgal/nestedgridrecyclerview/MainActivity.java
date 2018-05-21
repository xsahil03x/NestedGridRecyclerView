package com.developervishalsehgal.nestedgridrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.developervishalsehgal.nestedgridrecyclerview.Adapters.RecyclerViewDataAdapter;
import com.developervishalsehgal.nestedgridrecyclerview.models.SectionDataModel;
import com.developervishalsehgal.nestedgridrecyclerview.models.SingleItemModel;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerViewDataAdapter adapter;
    RecyclerView my_recycler_view;

    ArrayList<String> sectionOneItemNames, sectionTwoItemNames, sectionThreeItemNames, sectionFourItemNames, sectionFiveItemNames, sectionSixItemNames, sectionSevenItemNames, sectionEightItemNames, sectionNineItemNames, sectionTenItemNames, sectionElevenItemNames, sectionTwelveItemNames;
    ArrayList<String> sectionOneTransitionNames, sectionTwoTransitionNames, sectionThreeTransitionNames, sectionFourTransitionNames, sectionFiveTransitionNames, sectionSixTransitionNames, sectionSevenTransitionNames, sectionEightTransitionNames, sectionNineTransitionNames, sectionTenTransitionNames, sectionElevenTransitionNames, sectionTwelveTransitionNames;
    ArrayList<String> sone, stwo, sthree, sfour, sfive, ssix, sseven, seight, snine, sten, seleven, stwelve;
    ArrayList<SectionDataModel> allFinalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        allFinalData = new ArrayList<SectionDataModel>();

        arrayListsData();
        setUpData("System", sectionOneItemNames, allFinalData);
        setUpData("Network", sectionOneItemNames,  allFinalData);
        setUpData("Media", sectionOneItemNames,  allFinalData);
        setUpData("Communication", sectionOneItemNames,  allFinalData);
        setUpData("System", sectionOneItemNames, allFinalData);
        setUpData("Network", sectionOneItemNames,  allFinalData);
        setUpData("Media", sectionOneItemNames,  allFinalData);
        setUpData("Communication", sectionOneItemNames,  allFinalData);



        my_recycler_view = findViewById(R.id.my_home_recycler_view);
        adapter = new RecyclerViewDataAdapter(this, allFinalData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.getLayoutManager().setAutoMeasureEnabled(true);
        my_recycler_view.setHasFixedSize(true);
        my_recycler_view.setAdapter(adapter);

    }

    public void arrayListsData() {

        //SectionItems Names ArrayLists.
        sectionOneItemNames = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.section_one_items)));



    }

    public void setUpData(String sectionName, ArrayList<String> itemNames, ArrayList<SectionDataModel> allFinalData) {

        SectionDataModel model = new SectionDataModel();
        model.setHeaderTitle(sectionName);


        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        for (int i = 0; i < itemNames.size(); i++) {
            singleItem.add(new SingleItemModel(itemNames.get(i)));
        }

        model.setAllItemsInSection(singleItem);
        //Finally Adding allData to the ArrayList<SectionDataModel>.
        allFinalData.add(model);

    }

}
