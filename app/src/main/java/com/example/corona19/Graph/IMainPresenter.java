package com.example.corona19.Graph;

import java.util.ArrayList;

public interface IMainPresenter {
    void  downloadData();
    interface View {
        void showProgressBar();
        void hideProgressBar();
        void showError(String error);
        void datesDownloadedSuccessfully(ArrayList<String> datesArrayList, ArrayList<Status> statusArrayList);
    }
}
