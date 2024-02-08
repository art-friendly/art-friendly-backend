package com.example.artfriendly.exhibition.responseParser;

import com.example.artfriendly.exhibition.dto.PerformanceResponseDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ResponseParser {
    public static PerformanceResponseDTO parseXmlResponse(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = new ByteArrayInputStream(xmlString.getBytes());
        Document doc = builder.parse(is);

        // XML에서 필요한 데이터를 추출하여 PerformanceResponseDTO 객체에 설정
        PerformanceResponseDTO responseDTO = new PerformanceResponseDTO();
        Element root = doc.getDocumentElement();
        NodeList comMsgHeaderList = root.getElementsByTagName("comMsgHeader");
        if (comMsgHeaderList.getLength() > 0) {
            Element comMsgHeaderElement = (Element) comMsgHeaderList.item(0);
            String requestMsgID = getElementValue(comMsgHeaderElement, "RequestMsgID");
            String responseTime = getElementValue(comMsgHeaderElement, "ResponseTime");
            String responseMsgID = getElementValue(comMsgHeaderElement, "ResponseMsgID");
            String successYN = getElementValue(comMsgHeaderElement, "SuccessYN");
            String returnCode = getElementValue(comMsgHeaderElement, "ReturnCode");
            String errMsg = getElementValue(comMsgHeaderElement, "ErrMsg");
            // comMsgHeader를 설정
            responseDTO.setComMsgHeader(new PerformanceResponseDTO.ComMsgHeader(requestMsgID, responseTime, responseMsgID, successYN, returnCode, errMsg));
        }

        NodeList msgBodyList = root.getElementsByTagName("msgBody");
        if (msgBodyList.getLength() > 0) {
            Element msgBodyElement = (Element) msgBodyList.item(0);
            int totalCount = Integer.parseInt(getElementValue(msgBodyElement, "totalCount"));
            int cPage = Integer.parseInt(getElementValue(msgBodyElement, "cPage"));
            int rows = Integer.parseInt(getElementValue(msgBodyElement, "rows"));
            String realmCode = getElementValue(msgBodyElement, "realmCode");
            // perforList 추출
            List<PerformanceResponseDTO.PerforList> perforList = extractPerforList(msgBodyElement.getElementsByTagName("perforList"));
            // msgBody를 설정
            responseDTO.setMsgBody(new PerformanceResponseDTO.MsgBody(totalCount, cPage, rows, realmCode, perforList));
        }

        return responseDTO;
    }

    private static String getElementValue(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return null; // 노드가 존재하지 않는 경우 null 반환
    }

    private static List<PerformanceResponseDTO.PerforList> extractPerforList(NodeList perforListNodes) {
        List<PerformanceResponseDTO.PerforList> perforList = new ArrayList<>();
        for (int i = 0; i < perforListNodes.getLength(); i++) {
            Node perforListNode = perforListNodes.item(i);
            if (perforListNode.getNodeType() == Node.ELEMENT_NODE) {
                Element perforListElement = (Element) perforListNode;
                String seq = getElementValue(perforListElement, "seq");
                String title = getElementValue(perforListElement, "title");
                String startDate = getElementValue(perforListElement, "startDate");
                String endDate = getElementValue(perforListElement, "endDate");
                String place = getElementValue(perforListElement, "place");
                String realmName = getElementValue(perforListElement, "realmName");
                String area = getElementValue(perforListElement, "area");
                String thumbnail = getElementValue(perforListElement, "thumbnail");
                String gpsX = getElementValue(perforListElement, "gpsX");
                String gpsY = getElementValue(perforListElement, "gpsY");
                PerformanceResponseDTO.PerforList perfor = new PerformanceResponseDTO.PerforList(seq, title, startDate, endDate, place, realmName, area, thumbnail, gpsX, gpsY);
                perforList.add(perfor);
            }
        }
        return perforList;
    }
}