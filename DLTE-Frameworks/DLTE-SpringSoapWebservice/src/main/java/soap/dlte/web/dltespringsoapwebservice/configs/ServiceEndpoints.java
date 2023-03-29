package soap.dlte.web.dltespringsoapwebservice.configs;

import dltespringsoapwebservice.web.dlte.soap.NewOfficialRequest;
import dltespringsoapwebservice.web.dlte.soap.NewOfficialResponse;
import dltespringsoapwebservice.web.dlte.soap.ServiceStatus;
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

@Endpoint
public class ServiceEndpoints {
    private static final String url="http://soap.dlte.web.dltespringsoapwebservice";
    private Logger logger= LoggerFactory.getLogger(ServiceEndpoints.class);

    @Autowired
    private OfficialsService service;

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
