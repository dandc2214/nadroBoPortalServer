package nadroserverapp

import grails.transaction.Transactional
import com.crystaldecisions.sdk.framework.IEnterpriseSession
import java.net.URLEncoder
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import com.crystaldecisions.sdk.framework.CrystalEnterprise
import com.crystaldecisions.sdk.exception.SDKException

@Transactional
class OpenDocUrlGeneratorService {

    // String openDocumentSerSes(String partialUrl) throws SDKException, UnsupportedEncodingException{
        // IEnterpriseSession sess = CrystalEnterprise.getSessionMgr().logon("Administrator", "S1n37i#1", "192.168.0.59:6400", "secEnterprise");
        // String serSession = sess.getSerializedSession();
        // String serSesEncode = URLEncoder.encode(serSession, "UTF-8");
        // return """http://192.168.0.59:8080/BOE/OpenDocument/opendoc/openDocument.jsp
            // ?iDocID=AcHyxSNvu4tMpbWugdHQKCY
            // &sIDType=CUID
            // &serSes=""" + serSesEncode
    // }

    // String openDocumentToken() throws SDKException, UnsupportedEncodingException{
    //     IEnterpriseSession sess = CrystalEnterprise.getSessionMgr().logon("Administrator","S1n37i#1","192.168.0.59:6400","secEnterprise");
    //     String token = sess.getLogonTokenMgr().createLogonToken( "",120,100);
    //     String tokenEncode = URLEncoder.encode( token,"UTF-8");
    //     sess.logoff();
    //     return "http://192.168.0.59:8080/BOE/OpenDocument/opendoc/openDocument.jsp?sIDType=CUID&iDocID=AcHyxSNvu4tMpbWugdHQKCY&token=" + tokenEncode;
    // }

    String openDocumentToken(String userId) throws SDKException, UnsupportedEncodingException{
        IEnterpriseSession sess = CrystalEnterprise.getSessionMgr().logon("Administrator","S1n37i#1","172.16.2.199:6400","secEnterprise");
        String token = sess.getLogonTokenMgr().createLogonToken( "",120,100);
        String tokenEncode = URLEncoder.encode( token,"UTF-8");
        sess.logoff();
        return "http://172.16.2.199:8080/BOE/OpenDocument/opendoc/openDocument.jsp?iDocID=AVOnUGQw.s90u2UP2EZzPxw&sIDType=CUID&sType=wid&sRefresh=Y&lsMpmIDEmpleado=${userId}&lsIpmIDEmpleado=${userId}&token=${tokenEncode}"
    }

    // String openDocumentToken(String partialUrl) throws SDKException, UnsupportedEncodingException{
    //     IEnterpriseSession sess = CrystalEnterprise.getSessionMgr().logon("Administrator","S1n37i#1","192.168.0.59:6400","secEnterprise");
    //     String token = sess.getLogonTokenMgr().createLogonToken( "",120,100);
    //     String tokenEncode = URLEncoder.encode( token,"UTF-8");
    //     sess.logoff();
    //     return partialUrl + tokenEncode;
    // }
}
