package it.itsincom.projectwork.webdev24;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateTypeAdapter implements JsonSerializer<LocalDate> {

    // Definizione del formatter per formattare e analizzare le date
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Metodo per la serializzazione di un oggetto LocalDate in un elemento JSON
    @Override
    public JsonElement serialize(final LocalDate date, final Type typeOfSrc, final JsonSerializationContext context) {
        // Formatta la data come una stringa nel formato desiderato e la converte in un elemento JSON
        return new JsonPrimitive(date.format(formatter));
    }
}
