package cr.ac.itcr.examenkevin.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cr.ac.itcr.examenkevin.R;
import cr.ac.itcr.examenkevin.entity.Tortugas;

/**
 * Created by Kevin on 12/4/2016.
 */
public class Adapter extends BaseAdapter {



    Context context;
    LayoutInflater inflater;

    protected Activity activity;
    protected ArrayList<Tortugas> items;

    public Adapter (Context context, ArrayList<Tortugas> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Tortugas> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView txtNombre, txtPeso, txtColor, txtRaza;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_tortuga, parent, false);

        // Locate the TextViews in listview_item.xml
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombreAd);
        txtPeso = (TextView) itemView.findViewById(R.id.txtPesoAd);
        txtColor = (TextView) itemView.findViewById(R.id.txtColorAd);
        txtRaza = (TextView) itemView.findViewById(R.id.txtRazaAd);

        // Capture position and set to the TextViews
        txtNombre.setText(items.get(position).getNombre());
        txtPeso.setText(items.get(position).getPeso());
        txtColor.setText(items.get(position).getColor());
        txtRaza.setText(items.get(position).getRaza());

      /*  Picasso.with(itemView.getContext())
                .load("http://3.bp.blogspot.com/-JHKA0FV3pug/Vh_jEN6M0FI/AAAAAAAAL7g/i_qp76G644M/s1600/download-button.png")
                .resize(200, 150)
                .into(imgImg);

        imgImg.setImageResource(imagenes[0]);*/

        return itemView;
    }
}
