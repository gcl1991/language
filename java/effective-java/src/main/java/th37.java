import java.util.HashSet;
import java.util.Set;

public class th37 {
    public static void main(String[] args) {
        Set<Plant>[] plants = (Set<Plant> []) new Set[Plant.LifeCycle.values().length];
        for (int i=0;i<plants.length;i++){
            plants[i] = new HashSet<>();
        }
        Plant[] garden = {new Plant("草", Plant.LifeCycle.ANNUAL),new Plant("花", Plant.LifeCycle.BIENNIAL)};
        for(Plant p:garden){
            plants[p.lifeCycle.ordinal()].add(p);
        }
        for (int i=0;i<plants.length;i++){
            System.out.printf("%s %s %n",Plant.LifeCycle.values()[i],plants[i]);
        }
    }
    static class Plant{
        enum LifeCycle{ANNUAL,PERENNIAL,BIENNIAL}

        final String name;
        final LifeCycle lifeCycle;

        Plant(String name,LifeCycle lifeCycle){
            this.name = name;
            this.lifeCycle = lifeCycle;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
