package conversormonedas;

import java.util.Map;

public class ExchangeRateResponse {
    private String result;
    private Map<String, Double> conversion_rates;

    // Constructor por defecto
    public ExchangeRateResponse() {
    }

    // Getters y Setters
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
