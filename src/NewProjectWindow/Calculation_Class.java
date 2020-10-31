package NewProjectWindow;

public class Calculation_Class {

    static double area = 3000;
    static double floors = 2;
    static double blt_ar = 2000;
    static double str_ar = 50;
    static double extra_ac = 100;
    static int bedrooms = 2;
    static int bathrooms = 2;
    static int parking = 2;


    static int per_vol_conc_cost = 5000;
    static int per_cost_iron_rod = 500;
    static int per_cost_machinery = 5000;
    static double cost_water_bore_pin = 5000;
    static double cost_wire_25_90m = 2500;
    static int per_cost_casing = 200;

    static int per_cost_switch = 40;
    static int per_cost_tubelight = 300;
    static int per_cost_fan = 2500;
    static int per_cost_nightlight = 100;
    static int per_cost_plate = 200;
    static int per_cost_mbox = 500;
    static int per_cost_mcb = 300;
    static int per_cost_pipe = 500; // 10 ft
    static int per_cost_tap = 400;
    static int per_cost_basin  = 3000;
    static int per_cost_commode = 7000;
    static int per_cost_faucet = 1000;
    static int per_sqft_floor = 100;

    static int per_cost_plank = 1500;
    static int per_vol_paint_1 = 250;

    public static double Foundation_Phase_waterbore(){
        double cost_water_bore = cost_water_bore_pin;
        return cost_water_bore;
    }

    public static double Foundation_Phase_Digging(){

        double cost_machinery = (per_cost_machinery)* Math.ceil((blt_ar * 9)/(500*1));
        return cost_machinery;
    }

    public static double Foundation_Phase_Pillar(){
        int no_of_pillars = (int)Math.ceil(floors * (blt_ar)/(100));
        double vol_conc = no_of_pillars * (3) * (3) *(1.5);
        double cost_conc = vol_conc * (per_vol_conc_cost);

        int iron_rods = (int)((no_of_pillars)* (6) * (1.2) * Math.floor(10* floors /30));
        double cost_iron_rods = iron_rods * per_cost_iron_rod;
        double cost_labour_pillar = 5000 * no_of_pillars;

        return (cost_iron_rods + cost_conc+cost_labour_pillar) ;
    }


    public static double shell_building(){

        double cost_slabs = floors * blt_ar * (4/39.37) *per_vol_conc_cost;

        double steel_slabs = 1.2 * Math.ceil(blt_ar/100) * 4 * floors;
        double cost_steel_slabs = steel_slabs * per_cost_iron_rod;

        double labour_shell = Math.floor(blt_ar/25) * 1.2 * 500 * 4;

        return cost_slabs + cost_steel_slabs +labour_shell;

    }

    public static double electrical_works_floor(){

        double cables = (bedrooms) * ((Math.sqrt((blt_ar - str_ar- extra_ac)/bedrooms) * 4 * 3) )*3.2 + (bathrooms) * ((Math.sqrt((extra_ac)/bathrooms) * 4 * 3))*3.2;
        double cost_cables =((cables *3.2/90 ) * (cost_wire_25_90m));
        double cost_casing = (cables/32) * per_cost_casing;
        double cost_mcb = Math.ceil(bedrooms + bathrooms+2) * per_cost_mcb;


        double switches = 2 * (Math.ceil((blt_ar - str_ar - extra_ac) / 100) * (bedrooms) + Math.ceil((extra_ac) / 100) * bathrooms);
        double cost_switches = switches * per_cost_switch;
        double tubelights = Math.ceil((blt_ar-str_ar- extra_ac)/100) * (bedrooms) + Math.ceil(( extra_ac)/100) * bathrooms;
        double cost_tubelights = tubelights * per_cost_tubelight;
        double fans = Math.ceil((blt_ar-str_ar- extra_ac)/100) * (bedrooms);
        double cost_fans = fans * per_cost_fan;
        double nightlights = Math.ceil((blt_ar-str_ar- extra_ac)/100) * (bedrooms) + Math.ceil(( extra_ac)/100) * bathrooms;
        double cost_nightlights = per_cost_nightlight * nightlights;

        return (cost_cables + cost_casing + cost_fans + cost_switches + cost_mcb + cost_nightlights + cost_tubelights);

    }

    public static  double plumbing_works_floor(){
        double pipe_lgth = (bathrooms) * ((Math.sqrt((extra_ac)/bathrooms) * 4 * 3))*3.2 + 12* (floors) *1.2;
        double cost_pipe = pipe_lgth/10 * per_cost_pipe;
        double cost_taps = 3 * (bathrooms) * per_cost_tap;
        double cost_basin = 1 * (bathrooms) * per_cost_basin;
        double cost_commode = 1 * (bathrooms) * per_cost_commode;

        double cost_faucet = bathrooms * per_cost_faucet;

        double plumbing_labour = bathrooms * 3 * 800 + Math.ceil(pipe_lgth/20) * 800;

        return (plumbing_labour + cost_basin + cost_commode + cost_taps + cost_pipe + cost_faucet);
    }

    public static double carpentry_work_floor(){

        double carp_plank = 1.3 * bedrooms * 8;
        double cost_carp_plank = carp_plank * per_cost_plank;

        double door = (bedrooms + bathrooms) + 2;

        double cost_door = door * 2000;
        double window = (bedrooms * 2 + bathrooms * 1);
        double cost_window = window * 1250;

        double carp_labour = Math.ceil(carp_plank/2.5) * 700 + (door / 1.5) * 800 + (window/3) * 800;

        return cost_carp_plank + cost_door + cost_window ;

    }


    public static double painting(){
        double pnt_ar = 2* ((12 * floors * Math.sqrt(blt_ar)) + ( 12 * bedrooms * Math.sqrt((blt_ar - str_ar - extra_ac)/bedrooms)* 4 + blt_ar ));
        double cost_pnt_ar = (pnt_ar/100) * per_vol_paint_1;
        double pnt_labout =  (pnt_ar/200) * 700;

        return (cost_pnt_ar + pnt_labout);
    }

    public static double flooring(){

        double floor_ar = floors* blt_ar * 1.3 ;
        double cost_floor_ar = floor_ar * per_sqft_floor;

        double labour_flooring = Math.ceil(floor_ar/25) * 500;

        return (labour_flooring + cost_floor_ar);

    }

    public static double exterior_layout(){

        double ext_ar = area - blt_ar;
        double cost_ext_ar = ext_ar * 250;

        double cost_carParking = parking * 15000;

        return (cost_carParking+ cost_ext_ar);

    }
}
