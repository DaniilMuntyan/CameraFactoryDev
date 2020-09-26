package kpi.trspo.restapp.entities.employees;

import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.camera.Dimensions;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Converter
public class DefectsConverter implements AttributeConverter<List<Camera>, String> {

    @Override
    public String convertToDatabaseColumn(List<Camera> cameras) {
        StringBuilder s = new StringBuilder();
        for (Camera camera : cameras) {
            s.append(camera.getCamera_id().toString()).append(" ");
        }
        return s.toString();
    }

    @Override
    public List<Camera> convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<Camera> answer = new ArrayList<>();
        String[] ids = s.split(" ");
        for (String temp: ids) {
            Camera camera = new Camera();
            camera.setCamera_id(UUID.fromString(temp));
            answer.add(camera);
        }
        return answer;
    }
}
