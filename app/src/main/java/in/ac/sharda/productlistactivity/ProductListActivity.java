package in.ac.sharda.productlistactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import in.ac.sharda.loginactivity.MainActivity;
import in.ac.sharda.loginactivity.R;
import in.ac.sharda.productdetail.ProductDetailActivty;

public class ProductListActivity extends AppCompatActivity {
    ListView lst;
    int[] images = {R.drawable.merg,R.drawable.peppy,R.drawable.farm,R.drawable.veggie,R.drawable.paneer,R.drawable.fresh,R.drawable.corn,
    R.drawable.veg,R.drawable.del,R.drawable.mex};
    String[] names = {"Margherita","Peppy Paneer","Farm House","VEGGIE PARADISE","PANEER MAKHANI","FRESH VEGGIE","CHEESE N CORN","Veg Extravaganza",
    "Deluxe Veggie","Mexican Green Wave"};
    String[] desc = {"A hugely popular margherita, with a deliciously tangy single cheese topping","Chunky paneer with crisp capsicum and spicy red pepper - quite a mouthful!","A pizza that goes ballistic on veggies! Check out this mouth watering overload of crunchy, crisp capsicum, succulent mushrooms and fresh tomatoes",
    "Goldern Corn, Black Olives, Capsicum & Red Paprika","Paneer and Capsicum on Makhani Sauce","Onion I Capsicum","Cheese I Golden Corn",
    "A pizza that decidedly staggers under an overload of golden corn, exotic black olives, crunchy onions, crisp capsicum,etc...,.",
    "For a vegetarian looking for a BIG treat that goes easy on the spices, this one's got it all..",
    "A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes and jalapeno with a liberal sprinkling of exotic Mexican herbs."};
    String[] price ={"Price ₹99","Price ₹205","Price ₹235","Price ₹245","Price ₹255","Price ₹279","Price ₹285","Price ₹299","Price ₹399","Price ₹499"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        lst=(ListView)findViewById(R.id.lst);

        CustomAdapter customAdapter = new CustomAdapter();
        lst.setAdapter(customAdapter);

    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.merg);
            TextView textView_name = (TextView)view.findViewById(R.id.mg);
            TextView textView_desc = (TextView)view.findViewById(R.id.mgdes);
            TextView text_price = (TextView)view.findViewById(R.id.price);

            imageView.setImageResource(images[i]);
            textView_name.setText(names[i]);
            textView_desc.setText(desc[i]);
            text_price.setText(price[i]);

            return view;
        }

    }
}
