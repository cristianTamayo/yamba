package co.edu.udea.cmovil.gr3.yamba;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

public class StatusFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "StatusFragment";
    private EditText editStatus; //
    private Button buttonTweet;
    private TextView textCount; //
    private int defaultTextColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater
                .inflate(R.layout.fragment_status, container, false);
        editStatus = (EditText) view.findViewById(R.id.editStatus); //
        buttonTweet = (Button) view.findViewById(R.id.buttonTweet);
        textCount = (TextView) view.findViewById(R.id.textCount);
        buttonTweet.setOnClickListener(this);

        defaultTextColor =
                textCount.getTextColors().getDefaultColor();

        editStatus.addTextChangedListener(new TextWatcher() { //
            @Override
            public void afterTextChanged(Editable s) {
                int count = 140 - editStatus.length(); //
                textCount.setText(Integer.toString(count));
                textCount.setTextColor(Color.GREEN); //
                if (count < 10)
                    textCount.setTextColor(Color.RED);
                else
                    textCount.setTextColor(defaultTextColor);
            }
            @Override
            public void beforeTextChanged(CharSequence s,
                                          int start, int count,
                                          int after) { //
            }
            @Override
            public void onTextChanged(CharSequence s,
                                      int start, int before,
                                      int count) { //
            }
        });
        return view;
    }


    public void onClick(View view) { //
        String status = editStatus.getText().toString(); //
        new PostTask().execute(status);
    }

    private final class PostTask extends
            AsyncTask<String, Void, String> { //

        @Override
        protected String doInBackground(String... params) { //

            YambaClient yambaCloud =
                    new YambaClient("student", "password");
            try {
                yambaCloud.postStatus(params[0]); //
                return "Successfully posted";

            } catch (YambaClientException e) {
                e.printStackTrace();
                return "Failed to post to yamba service";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(StatusFragment.this.getActivity(),
                    result, Toast.LENGTH_LONG).show(); //
        }
    }
    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        Log.v(TAG, "fragment en: onAttach");
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "fragment en: onCreate");
    }
    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(TAG, "fragment en: onActivityCreated");
    }

    @Override
    public void onViewStateRestored (Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.v(TAG, "fragment en: onViewStateRestored");
    }

    @Override
    public void onStart () {
        super.onStart();
        Log.v(TAG, "fragment en: onStart");
    }

    @Override
    public void onResume () {
        super.onResume();
        Log.v(TAG, "fragment en: onResume");
    }

    @Override
    public void onPause () {
        super.onPause();
        Log.v(TAG, "fragment en: onPause");
    }

    @Override
    public void onStop () {
        super.onStop();
        Log.v(TAG, "fragment en: onStop");
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        Log.v(TAG, "fragment en: onDestroyView");
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        Log.v(TAG, "fragment en: onDestroy");
    }

    @Override
    public void onDetach () {
        super.onDetach();
        Log.v(TAG, "fragment en: onDetach");
    }


}
