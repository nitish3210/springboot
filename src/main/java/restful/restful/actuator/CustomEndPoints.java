//package restful.restful.actuator;
//
//import org.springframework.boot.actuate.endpoint.annotation.*;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component
//@Endpoint(id = "release-notes")
//public class CustomEndPoints {
//    Map<String, List<String>> releaseNotesmap = new HashMap<>();
//
//    public void initNotes(){
//        releaseNotesmap.put("v-1", Arrays.asList("Home Page created", "Added new items"));
//        releaseNotesmap.put("v-2", Arrays.asList("Reading From API", "Actuator End points Added"));
//    }
//
//    @ReadOperation
//    public Map<String, List<String>> getReleaseNotesmap(){
//        return releaseNotesmap;
//    }
//
//    //@Selector is work same as @pathVariable
//    @ReadOperation
//    public List<String> getReleaseNotesByVersion(@Selector String version){
//        return releaseNotesmap.get(version);
//    }
//
//    @WriteOperation
//    public void addReleaseNotes(@Selector String version, String releaseNotes){
//        releaseNotesmap.put(version,Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
//    }
//
//    @DeleteOperation
//    public void  deleteNotes(@Selector String version){
//        releaseNotesmap.remove(version);
//    }
//}
