package kpi.trspo.restapp.services.models;

import kpi.trspo.restapp.entities.employees.Manager;
import kpi.trspo.restapp.entities.machines.Calibrator;
import kpi.trspo.restapp.entities.machines.Packer;
import kpi.trspo.restapp.entities.machines.Tester;
import kpi.trspo.restapp.repositories.machine_repo.CalibratorRepository;
import kpi.trspo.restapp.repositories.machine_repo.PackerRepository;
import kpi.trspo.restapp.repositories.machine_repo.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class MachineService {

    private final CalibratorRepository calibratorRepository;

    private final TesterRepository testerRepository;

    private final PackerRepository packerRepository;

    @Autowired
    public MachineService(CalibratorRepository calibratorRepository, TesterRepository testerRepository,
                          PackerRepository packerRepository) {
        this.calibratorRepository = calibratorRepository;
        this.testerRepository = testerRepository;
        this.packerRepository = packerRepository;
    }

    public Calibrator findCalibrator(UUID calibratorId) {
        if (calibratorId == null)
            return null;

        return this.calibratorRepository.findById(calibratorId).orElse(null);
    }

    public Tester findTester(UUID testerId) {
        if(testerId == null)
            return null;

        return this.testerRepository.findById(testerId).orElse(null);
    }

    public Packer findPacker(UUID packerId) {
        if(packerId == null)
            return null;

        return this.packerRepository.findById(packerId).orElse(null);
    }

    public Calibrator save(Calibrator calibrator) {
        return this.calibratorRepository.save(calibrator);
    }

    public Packer save(Packer packer) {
        return this.packerRepository.save(packer);
    }

    public Tester save(Tester tester) {
        return this.testerRepository.save(tester);
    }

    public List<Calibrator> findAllCalibrators() {
        return this.calibratorRepository.findAll();
    }

    public List<Packer> findAllPackers() {
        return this.packerRepository.findAll();
    }

    public List<Tester> findAllTesters() {
        return this.testerRepository.findAll();
    }

}
