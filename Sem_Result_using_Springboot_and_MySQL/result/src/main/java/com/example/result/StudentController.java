package main.java.com.example.result;

import java.util.ArrayList;
import java.util.List;

public @RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {

    @Autowired private StudentRepo studentRepo;
    @Autowired private MSERepo mseRepo;
    @Autowired private ESERepo eseRepo;

    @PostMapping("/result")
    public List<Integer> saveResult(@RequestBody ResultDTO dto) {
        Student s = studentRepo.save(new Student(dto.getName(), dto.getRoll_no()));
        mseRepo.save(new MSE(s, dto.getMse()));
        eseRepo.save(new ESE(s, dto.getEse()));

        List<Integer> finalMarks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int mark = (dto.getMse().get(i) * 30 / 30) + (dto.getEse().get(i) * 70 / 70);
            finalMarks.add(mark);
        }
        return finalMarks;
    }
}