package kpi.trspo.restapp.services.models.camera;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Dimensions implements Comparable<Dimensions> {
    private Integer width;
    private Integer length;
    private Integer depth;

    public Dimensions(String s) {
        this(Integer.parseInt(s.split("x")[0]), Integer.parseInt(s.split("x")[1]),
                Integer.parseInt(s.split("x")[2]));
    }
    /*public Dimensions() {
        Random rand = new Random();
        this.width = 16 + rand.nextInt(10); // From 16 to 26 (standard, described in tester.checkDimensions: 25)
        this.length = 11 + rand.nextInt(10); // From 11 to 21 (standard: 20)
        this.depth = 6 + rand.nextInt(10); // From 6 to 16 (standard: 15)
    }*/

    @Override
    public String toString() {
        return width + "x" + length + "x" + depth + " см³";
    }

    @Override
    public int compareTo(Dimensions o) {
        return  (this.width <= o.width && this.length <= o.length && this.depth <= o.depth) ? 1 : -1;
    }

}
