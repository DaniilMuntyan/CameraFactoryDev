package kpi.trspo.restapp.services;

import javassist.NotFoundException;
import kpi.trspo.restapp.services.models.camera.*;
import kpi.trspo.restapp.services.models.employees.Collector;
import kpi.trspo.restapp.services.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class AssemblingService {

    @Autowired
    private CameraRepository cameraRepository;

    @Autowired
    private CameraBackRepository cameraBackRepository;

    @Autowired
    private CameraBodyRepository cameraBodyRepository;

    @Autowired
    private CameraLensRepository cameraLensRepository;

    @Autowired
    private CollectorRepository collectorRepository;

    public CameraBack assembleBack(UUID collectorId, Dimensions backDims,
                                   Integer resolution, Integer colorDepth) throws NotFoundException {

        if(collectorId == null) {
            return null;
        }

        Collector collector = this.findCollector(collectorId);

        if (collector == null) {
            throw new NotFoundException(String.format("Collector with id %s does not exist!", collectorId));
        }

        CameraBack cameraBack = collector.assemble(backDims, resolution, colorDepth);
        return cameraBackRepository.save(cameraBack);
    }

    public CameraBody assembleBody(UUID collectorId, Dimensions dimensions, String color) throws NotFoundException {
        if(collectorId == null) {
            return null;
        }

        Collector collector = this.findCollector(collectorId);

        if (collector == null) {
            throw new NotFoundException(String.format("Collector with id %s does not exist!", collectorId));
        }

        CameraBody cameraBody = collector.assemble(dimensions, color);

        return cameraBodyRepository.save(cameraBody);
    }

    public CameraLens assembleLens(UUID collectorId, Integer focalLength, LensType lensType) throws NotFoundException {
        if(collectorId == null) {
            return null;
        }

        Collector collector = this.findCollector(collectorId);

        if (collector == null) {
            throw new NotFoundException(String.format("Collector with id %s does not exist!", collectorId));
        }

        CameraLens cameraLens = collector.assemble(focalLength, lensType);

        return cameraLensRepository.save(cameraLens);
    }

    public Camera assembleCamera(UUID collectorId, UUID cameraBackId, UUID cameraBodyId,
                                 UUID cameraLensId) throws NotFoundException {

        if(collectorId == null || cameraBackId == null || cameraBodyId == null || cameraLensId == null) {
            return null;
        }

        Collector collector = this.findCollector(collectorId);

        if(collector == null) {
            throw new NotFoundException(String.format("Collector with id %s does not exist!", collectorId));
        }

        CameraBack cameraBack = this.findCameraBack(cameraBackId);

        if(cameraBack == null) {
            throw new NotFoundException(String.format("Camera back with id %s does not exist!", cameraBackId));
        }

        CameraBody cameraBody = this.findCameraBody(cameraBodyId);

        if(cameraBody == null) {
            throw new NotFoundException(String.format("Camera body with id %s does not exist!", cameraBodyId));
        }

        CameraLens cameraLens = this.findCameraLens(cameraLensId);

        if(cameraLens == null) {
            throw new NotFoundException(String.format("Camera lens with id %s does not exist!", cameraLensId));
        }

        Camera camera = collector.assemble(cameraBack, cameraBody, cameraLens);

        return this.cameraRepository.save(camera);
    }


    public CameraBack findCameraBack(UUID cameraBackId) {
        if (cameraBackId == null)
            return null;

        return this.cameraBackRepository.findById(cameraBackId).orElse(null);
    }

    public CameraBody findCameraBody(UUID cameraBodyId) {
        if (cameraBodyId == null)
            return null;

        return this.cameraBodyRepository.findById(cameraBodyId).orElse(null);
    }

    public CameraLens findCameraLens(UUID cameraLensId) {
        if (cameraLensId == null)
            return null;

        return this.cameraLensRepository.findById(cameraLensId).orElse(null);
    }

    public Collector findCollector(UUID collectorId) {
        if (collectorId == null)
            return null;

        return this.collectorRepository.findById(collectorId).orElse(null);
    }

    /*public List<CameraBack> findAllBack() {
        return cameraBackRepository.findAll();
    }

    public List<CameraBody> findAllBody() {
        return cameraBodyRepository.findAll();
    }

    public List<CameraLens> findAllLens() {
        return cameraLensRepository.findAll();
    }

    public List<Camera> findAllCamera() {
        return cameraRepository.findAll();
    }*/

    public CameraBack save(CameraBack cameraBack) {
        return this.cameraBackRepository.save(cameraBack);
    }

    public CameraBody save(CameraBody cameraBody) {
        return this.cameraBodyRepository.save(cameraBody);
    }

    public CameraLens save(CameraLens cameraLens) {
        return this.cameraLensRepository.save(cameraLens);
    }

    public Camera save(Camera camera) {
        return this.cameraRepository.save(camera);
    }

}
