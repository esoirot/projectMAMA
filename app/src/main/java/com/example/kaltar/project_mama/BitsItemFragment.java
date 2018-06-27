package com.example.kaltar.project_mama;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaltar.project_mama.dummy.DummyContent;
import com.example.kaltar.project_mama.dummy.DummyContent.DummyItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class BitsItemFragment extends Fragment {

    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_QUANTITY = "quantity";
    private static final String TAG_BITS = "bits";
    private static final String TAG_FACTION_ID = "faction_id";
    private static final String TAG_HEADS = "heads";
    private static final String TAG_TORSOS = "torsos";
    private static final String TAG_ARMS = "arms";
    private static final String TAG_LEGS = "legs";
    private static final String TAG_WEAPONS = "weapons";
    private static final String TAG_BACKPACKS = "backpacks";
    private static final String TAG_ACCESSORIES = "accessories";
    private static final String TAG_CHAOS = "chaos";
    private static final String TAG_IMPERIUM = "imperium";
    private static final String TAG_XENOS = "xenos";


    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_SEARCH_NAME = "search-name";
    private static final String ARG_SEARCH_TYPE = "search-type";
    private static final String ARG_SEARCH_FACTION = "search-faction";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private String search_name="";
    private String search_type="all";
    private String search_faction="all";

    protected RecyclerView mRecyclerView;
    protected MyBitsItemRecyclerViewAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;
    protected List<BitsList_tab_bits_list_item> user_bits_list_items;
    private static final int DATASET_COUNT = 2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BitsItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BitsItemFragment newInstance( String searchName, String searchType, String searchFaction) {
        BitsItemFragment fragment = new BitsItemFragment();
        fragment.search_name=searchName;
        fragment.search_type=searchType;
        fragment.search_faction=searchFaction;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user_bits_list_items=loadBits("","" ,"");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bitsitem_list, container, false);

        if (getArguments().getString("ARG_SEARCH_NAME")!=null &&  !getArguments().getString("ARG_SEARCH_NAME").isEmpty()){
            search_name =  getArguments().getString("ARG_SEARCH_NAME");
        }else{
            search_name = "";
        }

        if (getArguments().getString("ARG_SEARCH_TYPE")!=null  ){
            switch (getArguments().getString("ARG_SEARCH_TYPE").toLowerCase()) {
                case "heads":
                    search_type="H";
                    break;
                case "torsos":
                    search_type="T";
                    break;
                case "arms":
                    search_type="A";
                    break;
                case "legs":
                    search_type="L";
                    break;
                case "weapons":
                    search_type="W";
                    break;
                case "backpacks":
                    search_type="BP";
                    break;
                case "accessories":
                    search_type="ACC";
                    break;
                default:
                    search_type="all";
                    break;
            }
        }

        if (getArguments().getString("ARG_SEARCH_FACTION") != null ){
            switch(getArguments().getString("ARG_SEARCH_FACTION").toLowerCase()){
                case "chaos":
                    search_faction="C";
                    break;
                case "imperium":
                    search_faction="I";
                    break;
                case "xenos":
                    search_faction="X";
                    break;
                default:
                    search_faction="all";
                    break;
            };
        }

        user_bits_list_items = loadBits(search_name, search_type, search_faction);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set the adapter
        /*if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyBitsItemRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }*/
        mAdapter = new MyBitsItemRecyclerViewAdapter(user_bits_list_items);
        mRecyclerView.setAdapter(mAdapter);
        /*if (getArguments() != null) {
            search_name =  getArguments().getString("ARG_SEARCH_NAME");
            search_type =  getArguments().getString("ARG_SEARCH_TYPE");
            search_faction =  getArguments().getString("ARG_SEARCH_FACTION");
            loadBits(search_name,search_type,search_faction);
        }else{
            loadBits("","T","");
        }*/

        return view;
    }

    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i ;
        }
    }

    public List<BitsList_tab_bits_list_item> loadBits(String bits_name, String bits_type, String bits_faction){
        //Chercher dans le JSON
        String user_bits_json_string = loadJSONFromAsset("user_bits.json");
        String gw_bits_json_string = loadJSONFromAsset("gw_bits.json");
        String gw_factions_json_string = loadJSONFromAsset("gw_factions.json");
        //List<BitsList_tab_bits_list_item> user_bits_list_items = new ArrayList<>();
        user_bits_list_items = new ArrayList<>();
        try {

            JSONObject user_bits_json = new JSONObject(user_bits_json_string);
            JSONObject gw_bits_json = new JSONObject(gw_bits_json_string);
            JSONObject gw_factions_json = new JSONObject(gw_factions_json_string);

            JSONArray user_bits_list = user_bits_json.getJSONArray(TAG_BITS);
            JSONArray node = null;
            String type=null;
            JSONArray faction_node = null;
            JSONObject bit = null;
            JSONObject faction = null;

            for (int i = 0; i < user_bits_list.length(); i++) {
                JSONObject user_bit = user_bits_list.getJSONObject(i);
                String[] bit_id = user_bit.getString(TAG_ID).split("-");
                // id: = FACTION-SOUSFACTION-UNIT-PART-VARIANTE
                switch (bit_id[3]) {
                    case "H":
                        node = gw_bits_json.getJSONArray(TAG_HEADS);
                        type=TAG_HEADS;
                        break;
                    case "T":
                        node = gw_bits_json.getJSONArray(TAG_TORSOS);
                        type=TAG_TORSOS;
                        break;
                    case "A":
                        node = gw_bits_json.getJSONArray(TAG_ARMS);
                        type=TAG_ARMS;
                        break;
                    case "L":
                        node = gw_bits_json.getJSONArray(TAG_LEGS);
                        type=TAG_LEGS;
                        break;
                    case "W":
                        node = gw_bits_json.getJSONArray(TAG_WEAPONS);
                        type=TAG_WEAPONS;
                        break;
                    case "BP":
                        node = gw_bits_json.getJSONArray(TAG_BACKPACKS);
                        type=TAG_BACKPACKS;
                        break;
                    case "ACC":
                        node = gw_bits_json.getJSONArray(TAG_ACCESSORIES);
                        type=TAG_ACCESSORIES;
                        break;
                }

                // Ajout dans List items
                for (int j = 0; j < node.length(); j++) {
                    bit = node.getJSONObject(j);
                    if (user_bit.getString(TAG_ID).equals(bit.getString(TAG_ID))) {
                        String[] faction_id = bit.getString(TAG_ID).split("-");
                        switch (faction_id[0]) {
                            case "C":
                                faction_node = gw_factions_json.getJSONArray(TAG_CHAOS);
                                break;
                            case "I":
                                faction_node = gw_factions_json.getJSONArray(TAG_IMPERIUM);
                                break;
                            case "X":
                                faction_node = gw_factions_json.getJSONArray(TAG_XENOS);
                                break;
                        }

                        for (int k = 0; j < faction_node.length(); k++) {
                            faction = faction_node.getJSONObject(k);
                            if (bit.getString(TAG_FACTION_ID).equals(faction.getString(TAG_ID))) {
                                break;
                            }
                        }
                        break;
                    }
                }

                user_bits_list_items.add(new BitsList_tab_bits_list_item(bit.getString(TAG_NAME),
                        user_bit.getInt(TAG_QUANTITY),
                        faction.getString(TAG_ID),type));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        if(!bits_name.isEmpty()) {
            user_bits_list_items = find_bits_by_name(user_bits_list_items, bits_name);
        }

        if(bits_type != "all") {
            user_bits_list_items = find_by_bits_type(user_bits_list_items, bits_type);
        }

        if(bits_faction != "all") {
            user_bits_list_items = find_by_bits_faction(user_bits_list_items, bits_faction);
        }
        return user_bits_list_items;
    }

    private List<BitsList_tab_bits_list_item> find_bits_by_name(List<BitsList_tab_bits_list_item> user_bits_list_items, String bits_name) {
        return user_bits_list_items.stream().filter(c -> c.get_name().contains(bits_name)).collect(Collectors.toList());
    }

    private List<BitsList_tab_bits_list_item> find_by_bits_type(List<BitsList_tab_bits_list_item> user_bits_list_items, String bits_type){
        return user_bits_list_items.stream().filter(c -> c.get_type().contains(bits_type)).collect(Collectors.toList());
    }

    private List<BitsList_tab_bits_list_item> find_by_bits_faction(List<BitsList_tab_bits_list_item> user_bits_list_items, String bits_faction){
        return user_bits_list_items.stream().filter(c -> c.get_faction().contains(bits_faction)).collect(Collectors.toList());
    }

    //Lecteur fichier JSON
    public String loadJSONFromAsset(String json_file) {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open(json_file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
