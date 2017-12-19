
package at.webf.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.webf.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCoursesResponse_QNAME = new QName("http://ws.at/", "getCoursesResponse");
    private final static QName _Login_QNAME = new QName("http://ws.at/", "login");
    private final static QName _ShowPersonData_QNAME = new QName("http://ws.at/", "showPersonData");
    private final static QName _ShowCourseListResponse_QNAME = new QName("http://ws.at/", "showCourseListResponse");
    private final static QName _OutputPayloadCourse_QNAME = new QName("http://ws.at/", "outputPayloadCourse");
    private final static QName _OutputPayloadLogin_QNAME = new QName("http://ws.at/", "outputPayloadLogin");
    private final static QName _ShowCourseList_QNAME = new QName("http://ws.at/", "showCourseList");
    private final static QName _ShowPersonDataResponse_QNAME = new QName("http://ws.at/", "showPersonDataResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://ws.at/", "loginResponse");
    private final static QName _GetCourses_QNAME = new QName("http://ws.at/", "getCourses");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.webf.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutputPayloadCourse }
     * 
     */
    public OutputPayloadCourse createOutputPayloadCourse() {
        return new OutputPayloadCourse();
    }

    /**
     * Create an instance of {@link OutputPayloadLogin }
     * 
     */
    public OutputPayloadLogin createOutputPayloadLogin() {
        return new OutputPayloadLogin();
    }

    /**
     * Create an instance of {@link ShowCourseList }
     * 
     */
    public ShowCourseList createShowCourseList() {
        return new ShowCourseList();
    }

    /**
     * Create an instance of {@link ShowPersonDataResponse }
     * 
     */
    public ShowPersonDataResponse createShowPersonDataResponse() {
        return new ShowPersonDataResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetCourses }
     * 
     */
    public GetCourses createGetCourses() {
        return new GetCourses();
    }

    /**
     * Create an instance of {@link GetCoursesResponse }
     * 
     */
    public GetCoursesResponse createGetCoursesResponse() {
        return new GetCoursesResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link ShowPersonData }
     * 
     */
    public ShowPersonData createShowPersonData() {
        return new ShowPersonData();
    }

    /**
     * Create an instance of {@link ShowCourseListResponse }
     * 
     */
    public ShowCourseListResponse createShowCourseListResponse() {
        return new ShowCourseListResponse();
    }

    /**
     * Create an instance of {@link InputPayloadCourse }
     * 
     */
    public InputPayloadCourse createInputPayloadCourse() {
        return new InputPayloadCourse();
    }

    /**
     * Create an instance of {@link OutputPayloadPerson }
     * 
     */
    public OutputPayloadPerson createOutputPayloadPerson() {
        return new OutputPayloadPerson();
    }

    /**
     * Create an instance of {@link InputPayloadPerson }
     * 
     */
    public InputPayloadPerson createInputPayloadPerson() {
        return new InputPayloadPerson();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link InputPayloadLogin }
     * 
     */
    public InputPayloadLogin createInputPayloadLogin() {
        return new InputPayloadLogin();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoursesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "getCoursesResponse")
    public JAXBElement<GetCoursesResponse> createGetCoursesResponse(GetCoursesResponse value) {
        return new JAXBElement<GetCoursesResponse>(_GetCoursesResponse_QNAME, GetCoursesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowPersonData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "showPersonData")
    public JAXBElement<ShowPersonData> createShowPersonData(ShowPersonData value) {
        return new JAXBElement<ShowPersonData>(_ShowPersonData_QNAME, ShowPersonData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowCourseListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "showCourseListResponse")
    public JAXBElement<ShowCourseListResponse> createShowCourseListResponse(ShowCourseListResponse value) {
        return new JAXBElement<ShowCourseListResponse>(_ShowCourseListResponse_QNAME, ShowCourseListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputPayloadCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "outputPayloadCourse")
    public JAXBElement<OutputPayloadCourse> createOutputPayloadCourse(OutputPayloadCourse value) {
        return new JAXBElement<OutputPayloadCourse>(_OutputPayloadCourse_QNAME, OutputPayloadCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputPayloadLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "outputPayloadLogin")
    public JAXBElement<OutputPayloadLogin> createOutputPayloadLogin(OutputPayloadLogin value) {
        return new JAXBElement<OutputPayloadLogin>(_OutputPayloadLogin_QNAME, OutputPayloadLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowCourseList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "showCourseList")
    public JAXBElement<ShowCourseList> createShowCourseList(ShowCourseList value) {
        return new JAXBElement<ShowCourseList>(_ShowCourseList_QNAME, ShowCourseList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowPersonDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "showPersonDataResponse")
    public JAXBElement<ShowPersonDataResponse> createShowPersonDataResponse(ShowPersonDataResponse value) {
        return new JAXBElement<ShowPersonDataResponse>(_ShowPersonDataResponse_QNAME, ShowPersonDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "getCourses")
    public JAXBElement<GetCourses> createGetCourses(GetCourses value) {
        return new JAXBElement<GetCourses>(_GetCourses_QNAME, GetCourses.class, null, value);
    }

}
