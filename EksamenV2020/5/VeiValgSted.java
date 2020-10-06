import java.util.ArrayList;

public class VeiValgSted extends Sted{
  
  

    VeiValgSted(String b){
        super(b);
        
    }
    public void leggtilSted(Sted neste){
        if(!(nesteSted.contains(neste))){
        nesteSted.add(neste);
        }
    }

    @Override
    public void settRetning(){
        if(nesteSted.size()== 3){
            nesteSted.get(0).retning = "til hoyre";
            nesteSted.get(1).retning = "rett fram";
            nesteSted.get(2).retning = "til venstre";
        }
        else if(nesteSted.size()==2){
            nesteSted.get(0).retning = "til hoyre";
            nesteSted.get(1).retning = "rett fram";
            
        }
        else{
            nesteSted.get(0).retning = "rett fram";
        }

    }


}

   


