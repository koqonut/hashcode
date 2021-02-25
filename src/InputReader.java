import java.util.List;

public class InputReader {

    public static CityMap createFromFile(List<String> lines){
        StringBuilder sb = new StringBuilder();

        //read line 0;

        String[] line0 = lines.get(0).split(" ");
        int duration = Integer.valueOf(line0[0]);
        int intersections = Integer.valueOf(line0[1]);
        int streets = Integer.valueOf(line0[2]);
        int cars = Integer.valueOf(line0[3]);
        int scores = Integer.valueOf(line0[3]);

        CityMap cityMap = new CityMap(duration,intersections,streets,cars,scores);


        int id=0;
        int i=1;
        for(;i<=streets;i++){

            String[] line = lines.get(i).split(" ");
            int begin = Integer.valueOf(line[0]);
            int end = Integer.valueOf(line[1]);
            int time = Integer.valueOf(line[3]);
            Street street = new Street(id, begin,end,line[2],time);
            cityMap.streetMap.put(id,street);
            cityMap.streetName2Id.put(line[2],id);
            id++;

        }
        System.out.println("streets done  "+i);

        id=0;
        for(;i<=streets+cars;i++){
            String[] line = lines.get(i).split(" ");
            int noOfHops = Integer.valueOf(line[0]);
            CarPath cp = new CarPath(id,noOfHops);

            for(int k=0;k<noOfHops;k++){
                cp.streetList.add(cityMap.streetName2Id.get(line[1+k]));
            }
            cityMap.carPathMap.put(id,cp);
            id++;
        }
        System.out.println("car path done  "+i);

        return cityMap;
    }
}
