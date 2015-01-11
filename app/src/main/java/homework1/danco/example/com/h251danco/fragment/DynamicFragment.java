package homework1.danco.example.com.h251danco.fragment;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import homework1.danco.example.com.h251danco.DummyContent;
import homework1.danco.example.com.h251danco.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DynamicFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DynamicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CONTACT = "contact";
    private static final String CONTACT_NAME = "name";
    private static final String CONTACT_STREET_ADDRESS = "street_address";
    private static final String CITY_STATE_ZIP = "city_state_zip";

    private String contactId;
    private String contactName;
    private String contactStreetAddress;
    private String city, state, zip;
    private String dob;

    private OnFragmentInteractionListener mListener;


    public DynamicFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param item item for which to display details.
     * @return A new instance of fragment DynamicFragment.
     */
    public static DynamicFragment newInstance(DummyContent.DummyItem item) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        args.putParcelable(CONTACT, item);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.getClass().getSimpleName()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DummyContent.DummyItem item = null;
        if (savedInstanceState == null) {
            if (getArguments() != null) {
                item = getArguments().getParcelable(CONTACT);
            }
        } else {
            item = savedInstanceState.getParcelable(CONTACT);
        }

        contactName = item.name;
        contactStreetAddress = item.streetAddress;
        city= item.city;
        state = item.state;
        zip = item.zip;
        dob = item.birthDate;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(view);

        holder.contactName.setText(contactName);
        holder.contactName.setTypeface(Typeface.DEFAULT_BOLD);
        holder.contactName.setOnClickListener(this);
        holder.streetAddress.setText(
                String.format("%s\n%s, %s %s", contactStreetAddress, city, state, zip));
        holder.dob.setText(dob);
        holder.dob.setOnClickListener(this);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.contactDob:
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }


    static class ViewHolder {
        final TextView contactName;
        final EditText streetAddress;
        final TextView dob;


        ViewHolder(View view) {
            contactName = (TextView) view.findViewById(R.id.contact_name);
            streetAddress = (EditText) view.findViewById(R.id.contact_street_address);
            dob = (TextView) view.findViewById(R.id.contactDob);
        }
    }
}
