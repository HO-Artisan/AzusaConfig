package ho.artisan.azusaconfig.neoforge.api.entrypoint;

public class EntrypointLoadingException extends RuntimeException {
    public EntrypointLoadingException() {
        super();
    }

    public EntrypointLoadingException(String message) {
        super(message);
    }

    public EntrypointLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
