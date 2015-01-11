package homework1.danco.example.com.h251danco.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link homework1.danco.example.com.h251danco.fragment.DatePickerFragment.DatePickerFragmentListener} interface
 * to handle interaction events.
 * Use the {@link DatePickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatePickerFragment extends DialogFragment
        implements DialogInterface.OnClickListener, DatePickerDialog.OnDateSetListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String BIRTH_YEAR = "year";
    private static final String BIRTH_MONTH = "month";
    private static final String BIRTH_DAY_OF_MONTH = "day";

    private int year;
    private int month;
    private int day;

    private DatePickerFragmentListener mListener;


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
    public interface DatePickerFragmentListener {
        public void onOkSelected();
        public void onCancelSelected();
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param year birth year1.
     * @param month birth month.
     * @param day birth day of month.
     * @return A new instance of fragment DatePickerFragment.
     */
    public static DatePickerFragment newInstance(String year, String month, String day) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putString(BIRTH_YEAR, year);
        args.putString(BIRTH_MONTH, month);
        args.putString(BIRTH_DAY_OF_MONTH, day);
        fragment.setArguments(args);
        return fragment;
    }


    public DatePickerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DatePickerFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement DatePickerFragmentListener");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new DatePickerDialog(getActivity().getBaseContext(), this, year, month, day);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }


}
