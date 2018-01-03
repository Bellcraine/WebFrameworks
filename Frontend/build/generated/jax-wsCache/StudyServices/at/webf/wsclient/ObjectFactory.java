
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

    private final static QName _AddOrUpdateCourse_QNAME = new QName("http://ws.at/", "addOrUpdateCourse");
    private final static QName _AddOrUpdateCourseResponse_QNAME = new QName("http://ws.at/", "addOrUpdateCourseResponse");
    private final static QName _AddPersonToCourse_QNAME = new QName("http://ws.at/", "addPersonToCourse");
    private final static QName _AddPersonToCourseResponse_QNAME = new QName("http://ws.at/", "addPersonToCourseResponse");
    private final static QName _DeleteCourse_QNAME = new QName("http://ws.at/", "deleteCourse");
    private final static QName _DeleteCourseResponse_QNAME = new QName("http://ws.at/", "deleteCourseResponse");
    private final static QName _DeletePersonFromCourse_QNAME = new QName("http://ws.at/", "deletePersonFromCourse");
    private final static QName _DeletePersonFromCourseResponse_QNAME = new QName("http://ws.at/", "deletePersonFromCourseResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://ws.at/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://ws.at/", "getAllStudentsResponse");
    private final static QName _GetCourses_QNAME = new QName("http://ws.at/", "getCourses");
    private final static QName _GetCoursesResponse_QNAME = new QName("http://ws.at/", "getCoursesResponse");
    private final static QName _LoadCourseDetails_QNAME = new QName("http://ws.at/", "loadCourseDetails");
    private final static QName _LoadCourseDetailsResponse_QNAME = new QName("http://ws.at/", "loadCourseDetailsResponse");
    private final static QName _LoadCourseList_QNAME = new QName("http://ws.at/", "loadCourseList");
    private final static QName _LoadCourseListResponse_QNAME = new QName("http://ws.at/", "loadCourseListResponse");
    private final static QName _LoadPersonDetails_QNAME = new QName("http://ws.at/", "loadPersonDetails");
    private final static QName _LoadPersonDetailsResponse_QNAME = new QName("http://ws.at/", "loadPersonDetailsResponse");
    private final static QName _LoadStudentList_QNAME = new QName("http://ws.at/", "loadStudentList");
    private final static QName _LoadStudentListResponse_QNAME = new QName("http://ws.at/", "loadStudentListResponse");
    private final static QName _Login_QNAME = new QName("http://ws.at/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://ws.at/", "loginResponse");
    private final static QName _OutputPayloadCourse_QNAME = new QName("http://ws.at/", "outputPayloadCourse");
    private final static QName _OutputPayloadPerson_QNAME = new QName("http://ws.at/", "outputPayloadPerson");
    private final static QName _OutputPayloadPersonCourseMembership_QNAME = new QName("http://ws.at/", "outputPayloadPersonCourseMembership");
    private final static QName _StudentGetGrade_QNAME = new QName("http://ws.at/", "studentGetGrade");
    private final static QName _StudentGetGradeResponse_QNAME = new QName("http://ws.at/", "studentGetGradeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.webf.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddOrUpdateCourse }
     * 
     */
    public AddOrUpdateCourse createAddOrUpdateCourse() {
        return new AddOrUpdateCourse();
    }

    /**
     * Create an instance of {@link AddOrUpdateCourseResponse }
     * 
     */
    public AddOrUpdateCourseResponse createAddOrUpdateCourseResponse() {
        return new AddOrUpdateCourseResponse();
    }

    /**
     * Create an instance of {@link AddPersonToCourse }
     * 
     */
    public AddPersonToCourse createAddPersonToCourse() {
        return new AddPersonToCourse();
    }

    /**
     * Create an instance of {@link AddPersonToCourseResponse }
     * 
     */
    public AddPersonToCourseResponse createAddPersonToCourseResponse() {
        return new AddPersonToCourseResponse();
    }

    /**
     * Create an instance of {@link DeleteCourse }
     * 
     */
    public DeleteCourse createDeleteCourse() {
        return new DeleteCourse();
    }

    /**
     * Create an instance of {@link DeleteCourseResponse }
     * 
     */
    public DeleteCourseResponse createDeleteCourseResponse() {
        return new DeleteCourseResponse();
    }

    /**
     * Create an instance of {@link DeletePersonFromCourse }
     * 
     */
    public DeletePersonFromCourse createDeletePersonFromCourse() {
        return new DeletePersonFromCourse();
    }

    /**
     * Create an instance of {@link DeletePersonFromCourseResponse }
     * 
     */
    public DeletePersonFromCourseResponse createDeletePersonFromCourseResponse() {
        return new DeletePersonFromCourseResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
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
     * Create an instance of {@link LoadCourseDetails }
     * 
     */
    public LoadCourseDetails createLoadCourseDetails() {
        return new LoadCourseDetails();
    }

    /**
     * Create an instance of {@link LoadCourseDetailsResponse }
     * 
     */
    public LoadCourseDetailsResponse createLoadCourseDetailsResponse() {
        return new LoadCourseDetailsResponse();
    }

    /**
     * Create an instance of {@link LoadCourseList }
     * 
     */
    public LoadCourseList createLoadCourseList() {
        return new LoadCourseList();
    }

    /**
     * Create an instance of {@link LoadCourseListResponse }
     * 
     */
    public LoadCourseListResponse createLoadCourseListResponse() {
        return new LoadCourseListResponse();
    }

    /**
     * Create an instance of {@link LoadPersonDetails }
     * 
     */
    public LoadPersonDetails createLoadPersonDetails() {
        return new LoadPersonDetails();
    }

    /**
     * Create an instance of {@link LoadPersonDetailsResponse }
     * 
     */
    public LoadPersonDetailsResponse createLoadPersonDetailsResponse() {
        return new LoadPersonDetailsResponse();
    }

    /**
     * Create an instance of {@link LoadStudentList }
     * 
     */
    public LoadStudentList createLoadStudentList() {
        return new LoadStudentList();
    }

    /**
     * Create an instance of {@link LoadStudentListResponse }
     * 
     */
    public LoadStudentListResponse createLoadStudentListResponse() {
        return new LoadStudentListResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link OutputPayloadCourse }
     * 
     */
    public OutputPayloadCourse createOutputPayloadCourse() {
        return new OutputPayloadCourse();
    }

    /**
     * Create an instance of {@link OutputPayloadPerson }
     * 
     */
    public OutputPayloadPerson createOutputPayloadPerson() {
        return new OutputPayloadPerson();
    }

    /**
     * Create an instance of {@link OutputPayloadPersonCourseMembership }
     * 
     */
    public OutputPayloadPersonCourseMembership createOutputPayloadPersonCourseMembership() {
        return new OutputPayloadPersonCourseMembership();
    }

    /**
     * Create an instance of {@link StudentGetGrade }
     * 
     */
    public StudentGetGrade createStudentGetGrade() {
        return new StudentGetGrade();
    }

    /**
     * Create an instance of {@link StudentGetGradeResponse }
     * 
     */
    public StudentGetGradeResponse createStudentGetGradeResponse() {
        return new StudentGetGradeResponse();
    }

    /**
     * Create an instance of {@link InputPayloadCourse }
     * 
     */
    public InputPayloadCourse createInputPayloadCourse() {
        return new InputPayloadCourse();
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
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link PersonCourseMembershipId }
     * 
     */
    public PersonCourseMembershipId createPersonCourseMembershipId() {
        return new PersonCourseMembershipId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrUpdateCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "addOrUpdateCourse")
    public JAXBElement<AddOrUpdateCourse> createAddOrUpdateCourse(AddOrUpdateCourse value) {
        return new JAXBElement<AddOrUpdateCourse>(_AddOrUpdateCourse_QNAME, AddOrUpdateCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrUpdateCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "addOrUpdateCourseResponse")
    public JAXBElement<AddOrUpdateCourseResponse> createAddOrUpdateCourseResponse(AddOrUpdateCourseResponse value) {
        return new JAXBElement<AddOrUpdateCourseResponse>(_AddOrUpdateCourseResponse_QNAME, AddOrUpdateCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonToCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "addPersonToCourse")
    public JAXBElement<AddPersonToCourse> createAddPersonToCourse(AddPersonToCourse value) {
        return new JAXBElement<AddPersonToCourse>(_AddPersonToCourse_QNAME, AddPersonToCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonToCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "addPersonToCourseResponse")
    public JAXBElement<AddPersonToCourseResponse> createAddPersonToCourseResponse(AddPersonToCourseResponse value) {
        return new JAXBElement<AddPersonToCourseResponse>(_AddPersonToCourseResponse_QNAME, AddPersonToCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "deleteCourse")
    public JAXBElement<DeleteCourse> createDeleteCourse(DeleteCourse value) {
        return new JAXBElement<DeleteCourse>(_DeleteCourse_QNAME, DeleteCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "deleteCourseResponse")
    public JAXBElement<DeleteCourseResponse> createDeleteCourseResponse(DeleteCourseResponse value) {
        return new JAXBElement<DeleteCourseResponse>(_DeleteCourseResponse_QNAME, DeleteCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonFromCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "deletePersonFromCourse")
    public JAXBElement<DeletePersonFromCourse> createDeletePersonFromCourse(DeletePersonFromCourse value) {
        return new JAXBElement<DeletePersonFromCourse>(_DeletePersonFromCourse_QNAME, DeletePersonFromCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonFromCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "deletePersonFromCourseResponse")
    public JAXBElement<DeletePersonFromCourseResponse> createDeletePersonFromCourseResponse(DeletePersonFromCourseResponse value) {
        return new JAXBElement<DeletePersonFromCourseResponse>(_DeletePersonFromCourseResponse_QNAME, DeletePersonFromCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "getCourses")
    public JAXBElement<GetCourses> createGetCourses(GetCourses value) {
        return new JAXBElement<GetCourses>(_GetCourses_QNAME, GetCourses.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadCourseDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadCourseDetails")
    public JAXBElement<LoadCourseDetails> createLoadCourseDetails(LoadCourseDetails value) {
        return new JAXBElement<LoadCourseDetails>(_LoadCourseDetails_QNAME, LoadCourseDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadCourseDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadCourseDetailsResponse")
    public JAXBElement<LoadCourseDetailsResponse> createLoadCourseDetailsResponse(LoadCourseDetailsResponse value) {
        return new JAXBElement<LoadCourseDetailsResponse>(_LoadCourseDetailsResponse_QNAME, LoadCourseDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadCourseList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadCourseList")
    public JAXBElement<LoadCourseList> createLoadCourseList(LoadCourseList value) {
        return new JAXBElement<LoadCourseList>(_LoadCourseList_QNAME, LoadCourseList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadCourseListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadCourseListResponse")
    public JAXBElement<LoadCourseListResponse> createLoadCourseListResponse(LoadCourseListResponse value) {
        return new JAXBElement<LoadCourseListResponse>(_LoadCourseListResponse_QNAME, LoadCourseListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPersonDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadPersonDetails")
    public JAXBElement<LoadPersonDetails> createLoadPersonDetails(LoadPersonDetails value) {
        return new JAXBElement<LoadPersonDetails>(_LoadPersonDetails_QNAME, LoadPersonDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadPersonDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadPersonDetailsResponse")
    public JAXBElement<LoadPersonDetailsResponse> createLoadPersonDetailsResponse(LoadPersonDetailsResponse value) {
        return new JAXBElement<LoadPersonDetailsResponse>(_LoadPersonDetailsResponse_QNAME, LoadPersonDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadStudentList")
    public JAXBElement<LoadStudentList> createLoadStudentList(LoadStudentList value) {
        return new JAXBElement<LoadStudentList>(_LoadStudentList_QNAME, LoadStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loadStudentListResponse")
    public JAXBElement<LoadStudentListResponse> createLoadStudentListResponse(LoadStudentListResponse value) {
        return new JAXBElement<LoadStudentListResponse>(_LoadStudentListResponse_QNAME, LoadStudentListResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputPayloadPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "outputPayloadPerson")
    public JAXBElement<OutputPayloadPerson> createOutputPayloadPerson(OutputPayloadPerson value) {
        return new JAXBElement<OutputPayloadPerson>(_OutputPayloadPerson_QNAME, OutputPayloadPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputPayloadPersonCourseMembership }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "outputPayloadPersonCourseMembership")
    public JAXBElement<OutputPayloadPersonCourseMembership> createOutputPayloadPersonCourseMembership(OutputPayloadPersonCourseMembership value) {
        return new JAXBElement<OutputPayloadPersonCourseMembership>(_OutputPayloadPersonCourseMembership_QNAME, OutputPayloadPersonCourseMembership.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentGetGrade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "studentGetGrade")
    public JAXBElement<StudentGetGrade> createStudentGetGrade(StudentGetGrade value) {
        return new JAXBElement<StudentGetGrade>(_StudentGetGrade_QNAME, StudentGetGrade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentGetGradeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.at/", name = "studentGetGradeResponse")
    public JAXBElement<StudentGetGradeResponse> createStudentGetGradeResponse(StudentGetGradeResponse value) {
        return new JAXBElement<StudentGetGradeResponse>(_StudentGetGradeResponse_QNAME, StudentGetGradeResponse.class, null, value);
    }

}
