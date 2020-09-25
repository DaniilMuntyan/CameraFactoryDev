package kpi.trspo.restapp.services.models.camera;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DimensionsConverter implements AttributeConverter<Dimensions, String> {

    private static final String SEPARATOR = "x";

    @Override
    public String convertToDatabaseColumn(Dimensions dimensions) {
        if(dimensions == null) {
            return null;
        }

        System.out.println("IN convertToDatabaseColumn");
        StringBuilder sb = new StringBuilder();
        sb.append(dimensions.getWidth()).append(SEPARATOR).append(dimensions.getLength())
                .append(SEPARATOR).append(dimensions.getDepth());
        return sb.toString();
    }

    @Override
    public Dimensions convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        String[] dimensions = s.split("x");
        System.out.println("IN convertToEntityAttribute");
        return new Dimensions(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]),
                Integer.parseInt(dimensions[2]));
    }
}
