package br.com.alura.estoque.retrofit.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class CallbackSemRetorno implements Callback<Void> {

    private final CallbackSemRetorno.RespostaCallback callback;

    public CallbackSemRetorno(RespostaCallback callback1) {

        this.callback = callback1;
    }


    @Override
    @EverythingIsNonNull
    public void onResponse(Call<Void> call, Response<Void> response) {
        if(response.isSuccessful()){
            callback.quandoSucesso();
        }else{
            callback.quandoFalha("Respota não sucedida");
        }
    }

    @Override
    @EverythingIsNonNull
    public void onFailure(Call<Void> call, Throwable t) {
        callback.quandoFalha("Falha na comunicação: " + t.getMessage());
    }

    public interface RespostaCallback{
        void quandoSucesso();
        void quandoFalha(String erro);
    }
}
