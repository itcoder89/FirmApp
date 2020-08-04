package Interfaces;

/**
 * Created by Suresh kumar on 4/2/2020.
 */

public interface OnResponse<T> {
    void onSucess(T response);
    void onError(String error);
}
