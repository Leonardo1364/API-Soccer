package com.soccer.resttemplateconfig;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestHandle implements ResponseErrorHandler {

    public boolean hasError(ClientHttpResponse response) throws IOException {
        return false;
    }

    public void handleError(ClientHttpResponse response) throws IOException {

    }


    /*public class RestTemplateResponseErrorHandler
            implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse httpResponse)
                throws IOException {

            return (
                    httpResponse.getStatusCode().series() == CLIENT_ERROR
                            || httpResponse.getStatusCode().series() == SERVER_ERROR);
        }

        @Override
        public void handleError(ClientHttpResponse httpResponse)
                throws IOException {

            if (httpResponse.getStatusCode()
                    .series() == SERVER_ERROR) {
                // handle SERVER_ERROR
            } else if (httpResponse.getStatusCode()
                    .series() == CLIENT_ERROR) {
                // handle CLIENT_ERROR
                if (httpResponse.getStatusCode() == NOT_FOUND) {
                    throw new ChangeSetPersister.NotFoundException();
                }
            }
        }
    }*/
}
