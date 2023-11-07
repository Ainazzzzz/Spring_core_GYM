package org.spring_core;

import lombok.RequiredArgsConstructor;
import org.spring_core.Service.*;
import lombok.Data;
import org.spring_core.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

@Component
@Data
@RequiredArgsConstructor
public class DataInitializer {

    private final ApplicationContext applicationContext;;
    @Autowired
    private Storage storage;
    @Autowired
    private TraineeService traineeService;
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private TrainingTypeService trainingTypeService;;
    @Autowired
    private UserService userService;
    @Value("${data.path}")
    private String dataPath;


    public void init() {

        Properties properties = loadProperties();

        for (int userId: new int[]{0,1,2}) {
            int id = Integer.parseInt(properties.getProperty("users[" + userId + "].id"));
            String first_name = properties.getProperty("users[" + userId + "].first_name");
            String last_name = properties.getProperty("users[" + userId + "].last_name");
            String active = properties.getProperty("users[" + userId + "].isActive");
            boolean isActvie = Boolean.parseBoolean(active);

            User user = applicationContext.getBean("user", User.class);
            user.setId(id);
            user.setFirstAndLastName(first_name, last_name);
            user.setActive(isActvie);
            userService.save(user, storage.getUserMap());

        }
        for (int traineeId : new int[]{0,1}) {
            int id = Integer.parseInt(properties.getProperty("trainees[" + traineeId   + "].id"));
            String dateStr = properties.getProperty("trainees[" + traineeId + "].date");
            LocalDate date = LocalDate.parse(dateStr);
            String address = properties.getProperty("trainees[" + traineeId + "].Address");

            Trainee trainee = new Trainee();
            trainee.setId(id);
            trainee.setDate(date);
            trainee.setAddress(address);
            trainee.setUser(storage.getUserMap().get(new Scanner(System.in).nextLong()));
            traineeService.save(trainee, storage.getTraineeMap());
        }
        for (int trainingTypeId : new int[]{0, 1, 2}) {
            int id = Integer.parseInt(properties.getProperty("trainingTypes[" + trainingTypeId + "].id"));
            String name = properties.getProperty("trainingTypes[" + trainingTypeId + "].name");

            TrainingType trainingType =new TrainingType();
            trainingType.setId(id);
            trainingType.setTrainingType(name);
            trainingTypeService.save(trainingType, storage.getTrainingTypeMap());
        }

        for (int trainerId : new int[]{0, 1}) {
            int id = Integer.parseInt(properties.getProperty("trainers[" + trainerId + "].id"));

            Trainer trainer = new Trainer();
            trainer.setId(id);
            trainer.setSpecialization(storage.getTrainingTypeMap().get(new Scanner(System.in).nextLong()));
            trainerService.save(trainer, storage.getTrainerMap());
        }

        for (int trainingId : new int[]{0, 1}) {
            int id = Integer.parseInt(properties.getProperty("trainings[" + trainingId + "].id"));
            String trainingDateStr = properties.getProperty("trainings[" + trainingId + "].trainingDate");
            LocalDate trainingDate = LocalDate.parse(trainingDateStr);
            int trainingDuration = Integer.parseInt(properties.getProperty("trainings[" + trainingId + "].trainingDuration"));
            Duration duration = Duration.parse("PT" + trainingDuration + "H");

            Training training =new Training();
            training.setId(id);
            training.setTrainee(storage.getTraineeMap().get(new Scanner(System.in).nextLong()));
            training.setTrainer(storage.getTrainerMap().get(new Scanner(System.in).nextLong()));
            training.setTrainingType(storage.getTrainingTypeMap().get(new Scanner(System.in).nextLong()));
            training.setTrainingDate(trainingDate);
            training.setTrainingDuration(duration);
            trainingService.save(training, storage.getTrainingMap());
        }
    }
    public Properties loadProperties() {
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(dataPath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }



}

