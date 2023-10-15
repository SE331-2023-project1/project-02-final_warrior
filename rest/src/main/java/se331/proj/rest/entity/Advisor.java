package se331.proj.rest.entity;

import java.util.ArrayList;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Advisor {
    Integer id;
    String name;
    String surname;
    String imageLink;
    String dept;
    String position;
    ArrayList<Integer> studentId;
}
