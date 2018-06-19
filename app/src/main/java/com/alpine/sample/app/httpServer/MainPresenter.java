package com.alpine.sample.app.httpServer;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;

import com.alpine.sample.app.databinding.ActivityMainBinding;
import com.alpine.sample.service.I19BbService;

public class MainPresenter {
  @NonNull
  private final ActivityMainBinding binding;
  @NonNull
  private final Application application;

  public MainPresenter(@NonNull ActivityMainBinding binding, @NonNull Application application) {
    this.binding = binding;
    this.application = application;
  }

  public void onClickStartService() {
    try {
      startService();
    } catch (Throwable e) {
      Log.wtf(getClass().getSimpleName(), e);
    }
  }

  private void startService() throws RemoteException {
    I19BbService service = application.getI19BbService();
    service.start();
  }

  public void onClickStopService() {
    try {
      stopService();
    } catch (Throwable e) {
      Log.wtf(getClass().getSimpleName(), e);
    }
  }

  private void stopService() throws RemoteException {
    I19BbService service = application.getI19BbService();
    service.stop();
  }
}
