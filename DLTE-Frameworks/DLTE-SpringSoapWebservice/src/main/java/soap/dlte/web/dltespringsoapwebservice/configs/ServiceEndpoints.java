package soap.dlte.web.dltespringsoapwebservice.configs;

import dltespringsoapwebservice.web.dlte.soap.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.dlte.web.dltespringsoapwebservice.hibernate.OfficialsPojo;
import soap.dlte.web.dltespringsoapwebservice.hibernate.OfficialsService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

@Endpoint
public class ServiceEndpoints {
    private static final String url="http://soap.dlte.web.dltespringsoapwebservice";
    private Logger logger= LoggerFactory.getLogger(ServiceEndpoints.class);

    @Autowired
    private OfficialsService service;

    @PayloadRoot(namespace = url,localPart = "deleteViaIdRequest")
    @ResponsePayload
    public DeleteViaIdResponse deleteViaIdResponse(@RequestPayload DeleteViaIdRequest deleteViaIdRequest){
        DeleteViaIdResponse response=new DeleteViaIdResponse();
        ServiceStatus serviceStatus=new ServiceStatus();

        String information=service.remove(deleteViaIdRequest.getId());
        serviceStatus.setStatus("Success");
        serviceStatus.setMessage(information);

        response.setServiceStatus(serviceStatus);

        return response;
    }

    @PayloadRoot(namespace = url,localPart = "getByIdRequest")
    @ResponsePayload
    public GetByIdResponse getByIdResponse(@RequestPayload GetByIdRequest getByIdRequest){
        logger.trace(getByIdRequest.getId()+" received");
        GetByIdResponse response=new GetByIdResponse();
        Officials officials=new Officials();

        BeanUtils.copyProperties(service.read(getByIdRequest.getId()),officials);
        response.setOfficial(officials);

        return response;
    }

    @PayloadRoot(namespace = url,localPart = "listOfficialRequest")
    @ResponsePayload
    public ListOfficialResponse listOfficialResponse(@RequestPayload ListOfficialRequest listOfficialRequest){
        ListOfficialResponse response=new ListOfficialResponse();
        ServiceStatus serviceStatus=new ServiceStatus();

        List<OfficialsPojo> jpaComponent = service.list();// pojo objects
        List<Officials> officialsList=new ArrayList<>();// xml list of objects as of its empty

        Iterator<OfficialsPojo> it= jpaComponent.iterator();
        while(it.hasNext()){
            Officials officials=new Officials();// XSD POJO
            BeanUtils.copyProperties(it.next(),officials);
            officialsList.add(officials);
        }

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Official's are fetched from Table");

        response.setServiceStatus(serviceStatus);
        response.getOfficial().addAll(officialsList);

        return response;
    }

    @PayloadRoot(namespace = url,localPart = "newOfficialRequest")
    @ResponsePayload
    public NewOfficialResponse newOfficialResponse(@RequestPayload NewOfficialRequest newOfficialRequest){
        NewOfficialResponse newOfficialResponse=new NewOfficialResponse();
        OfficialsPojo pojo=new OfficialsPojo();
        ServiceStatus serviceStatus=new ServiceStatus();
        logger.info("Request object received yet to convert to Entity");
        // source,target
        BeanUtils.copyProperties(newOfficialRequest.getOfficial(),pojo);
        logger.info("Entity object received properties from request");
        service.create(pojo);
        logger.trace("Entity has inserted");
        serviceStatus.setStatus("Success");
        serviceStatus.setMessage("Object Inserted");
        newOfficialResponse.setOfficial(newOfficialRequest.getOfficial());
        newOfficialResponse.setServiceStatus(serviceStatus);
        logger.info("response object assembled yet to send");
        return newOfficialResponse;
    }
}
