/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author szere
 */
@Path("champion")
@ApplicationScoped
public class ChampionResource {
    private List<Champion> Champions = new ArrayList<>();
    
    public ChampionResource(){
        Champion Aatrox = new Champion();
        Aatrox.setName("Aatrox");
        Aatrox.setDescription("After a brief delay, Aatrox pulls in the farthest enemies then slams the ground, dealing magic damage to all adjacent enemies");
        Aatrox.setAbility("Infernal Chains");
        Aatrox.setDamage(250);
        Aatrox.setTraits("Cultist | Vanguard");
        Champions.add(Aatrox);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(
            @FormParam("name") String pName, 
            @FormParam("desc") String pDesc,
            @FormParam("ablity") String pAbility,
            @FormParam("dmg") int pDmg,
            @FormParam("traits") String pTraits){
        List<Champion> tmp = Champions.stream()
                .filter(Champion -> Champion.getName().equals(pName))
                .collect(Collectors.toList());
        
        if(tmp.isEmpty()) {
            Champion New = new Champion();
            New.setName(pName);
            New.setDescription(pDesc);
            New.setAbility(pAbility);
            New.setDamage(pDmg);
            New.setTraits(pTraits);

            Champions.add(New);
            return Response.ok(New).build();
        }
        else {
            return Response.status(500).build();
        }            
        
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Champion> getAll(){return Champions;}
    
    @GET
    @Path("/{Name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@PathParam("Name") @DefaultValue("") String pName){
        List<Champion> tmp = Champions.stream()
                .filter(Champion -> Champion.getName().equals(pName))
                .collect(Collectors.toList());
        
        if(tmp.isEmpty()) {
            return Response.status(404).build();
        }
        else if(tmp.size()>1) {
            return Response.status(500).build();
        }
        else{
            return Response.ok(tmp.get(0)).build();
        }            
    }
}
