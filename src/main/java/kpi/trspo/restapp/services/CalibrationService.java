package kpi.trspo.restapp.services;

import com.sun.xml.internal.ws.api.databinding.ClientCallBridge;
import javafx.util.Pair;
import kpi.trspo.restapp.entities.camera.Camera;
import kpi.trspo.restapp.entities.camera.CameraBack;
import kpi.trspo.restapp.entities.machines.Calibrator;
import kpi.trspo.restapp.services.models.CameraService;
import kpi.trspo.restapp.services.models.MachineService;
import kpi.trspo.restapp.services.validation.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class CalibrationService {

    @Autowired
    private CameraService cameraService;

    @Autowired
    private MachineService machineService;

    @Autowired
    private ValidService validService;

    public Camera calibrateCamera(UUID calibratorId, UUID cameraId) throws Exception {
        Pair<Calibrator, Camera> calibrator_camera = this.getCalibratorAndCamera(calibratorId, cameraId);
        Calibrator calibrator = calibrator_camera.getKey();
        Camera camera = calibrator_camera.getValue();

        CameraBack cameraBack = this.cameraService.findCameraBack(camera.getCameraBack().getId());
        calibrator.checkMatrix(cameraBack);
        this.cameraService.save(cameraBack);

        calibrator.innerCharacteristics(camera);

        return this.cameraService.save(camera);
    }

    private Pair<Calibrator, Camera> getCalibratorAndCamera(UUID calibratorId, UUID cameraId) throws Exception {
        this.validService.checkValidId(calibratorId, Calibrator.class);
        this.validService.checkValidId(cameraId, Camera.class);

        Calibrator calibrator = this.machineService.findCalibrator(calibratorId);
        Camera camera = this.cameraService.findCamera(cameraId);

        this.validService.checkObjectNotFound(calibrator, calibratorId);
        this.validService.checkObjectNotFound(camera, cameraId);

        return new Pair<>(calibrator, camera);
    }
}
