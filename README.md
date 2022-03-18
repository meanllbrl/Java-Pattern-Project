<div class="page-body"><p id="9eef043e-8cd0-4aeb-b952-73645703dac2" class="">
</p><h3 id="2c77fd6b-aebc-4353-a502-41f5f0ac7e40" class="">GİRİŞ</h3><p id="1ef4dbd6-dec8-4839-b3a1-e78806582d19" class="">Proje kapsamındaki temel gereksinimler:</p><ol type="1" id="ff3e9be5-3e7a-495a-a617-49be4d21cb31" class="numbered-list" start="1"><li>Bir firmanın çalışanlarına ilişkin hiyerarşik yapının, uygun bir tasarım deseni kullanılarak  temsil edilmesi.</li></ol><ol type="1" id="51232069-bdf2-4e78-8659-36d7f76db3a4" class="numbered-list" start="2"><li>Hiyerarşik yapının dolaşılması için Iterator deseni kullanılması.</li></ol><ol type="1" id="5d00b610-cc04-490c-84af-ecc55986f98a" class="numbered-list" start="3"><li>Bir Deneme sınıfı yazarak, bu sınıfın main metodu içinde, verilen (girdi.txt) dosyayı okuyarak verilmiş olan hiyerarşik yapıyı ilgili nesnelerle oluşturulması.</li></ol><ol type="1" id="70ca0015-1157-4736-820d-a52bf326396d" class="numbered-list" start="4"><li>Geliştirilen uygulamaya ilişkin bir işlevselliği (veya bir senaryoyu) gerçekleştirirken,  JUnit kullanarak birim testlere dayalı geliştirilmesi.</li></ol><p id="a9e8cc9b-73df-47db-aeab-9fd24997e802" class="">Temel gereksinimleri belirtilen projede bu gereksinimlerin;</p><ul id="7f080e1f-ce7a-4805-ae9b-8c64291f1e96" class="bulleted-list"><li style="list-style-type:disc">İlk maddesi olan hiyerarşik yapı için kullandığımız tasarım deseni COMPOSITE tasarım desenidir. Bu deseni kullanmak için öncelikle firmanın hiyerarşik yapısında bulunan direktör ve memur çalışanlarının ortak özelliklerini ve metotlarını içeren bir EMPLOYEE adında abstract class ı oluşturuldu. Ardından bu EMPLOYEE sınıfından kalıtım alan DIRECTOR ve OFFICER sınıfları oluşturuldu. Ve bu iki sınıfımızdan girdi.text dosyasında verilen verilere göre sırayla dosya okuma yapılarak direktör veya memur olduğunu belirleyip gerekli nesneler oluşturulup ve bu firmada olan hiyerarşik yapının ağaç şeklinde oluşturulması için EmployeeComposite sınıfı oluşturuldu.</li></ul><ul id="ef9f5c7e-46e9-4f46-8c5c-37f69a9859ed" class="bulleted-list"><li style="list-style-type:disc">Temel gereksinimlerin ikinci maddesinde bu hiyerarşik yapının dolaşılması ve ihtiyaç olunan koleksiyonun oluşturulmasında iterator dosyasında LinkedList sınıfı oluşturulmuştur.</li></ul><ul id="46bac4e4-9ffe-497f-a227-8894b3474e20" class="bulleted-list"><li style="list-style-type:disc">Ardında üçüncü maddede deneme sınıfı yazılıp main metodu içinde dosya okuma işlemi gerçekleştirilip nesneler oluşturulmuştur.</li></ul><ul id="4b86ac7e-f2fb-4e97-8e87-8f0d9450cffd" class="bulleted-list"><li style="list-style-type:disc">Son olarak bu uygulama geliştirilirken test dosyasında oluşturulan oop1test sınıfında junit kullanılarak birim teste dayalı bir şekilde çalışmaya tabi tutulmuştur.</li></ul><p id="52c23e10-ad11-481d-bb76-f2cab019e33e" class="">Şekil 1’ de de verilen projenin composite tasarım desenine uygun olarak çizilmiş UML sınıf diyagramında sınıflar arası ilişki gösterilmektedir.</p><h3 id="5e855f22-8691-473d-8ff5-99a3ad24ed36" class="">PROGRAMIN ÇALIŞMASI VE ÖZELLİKLERİ</h3><p id="d6a1d9a1-e974-4f29-bb8e-ce7804f2723c" class="">EMPLOYEE Sınıfı</p><pre id="169eb11f-961b-47c6-b85e-4e498aa4a9b2" class="code"><code>public abstract class Employee {
    private String nameSurname;
    private int salary;

    public Employee(String nameSurname, int salary) {
        this.nameSurname = nameSurname;
        this.salary = salary;
    }

    public String getNameSurname() {
        return this.nameSurname;
    }

    public String getName() {
        return this.nameSurname.split(" ")[0].trim();
    }

    public int getCost() {
        return this.salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void add(Employee employee) {
        throw new UnsupportedOperationException();

    }

    public void remove(Employee employee) {
        throw new UnsupportedOperationException();

    }

    public Employee getEmployee(int employeeIndex) {
        throw new UnsupportedOperationException();

    }

    public void displayEmployeeInfo(boolean isCost) {
        throw new UnsupportedOperationException();

    }

}</code></pre><p id="9571b920-fe89-4664-82ce-9712c62a523d" class="">EMPLOYEE sınıfı firmadaki hiyerarşik yapıda bulunan direktör ve memur çalışanların ortak olan isim ve maaş bilgilerini tutan sınıf olarak oluşturulmuştur.</p><p id="5699cbcf-9bed-402e-b172-0da4f9237928" class="">OFFICER Sınıfı</p><pre id="8c8ebdfa-fa21-4bbf-b989-5b2ce4a98ace" class="code"><code>public class Officer extends Employee {
    public Officer(String nameSurname, int salary) {
        super(nameSurname, salary);
    }

    // memurların bilgilerini yazdıran metod
    public void displayEmployeeInfo(boolean isCost) {
        System.out.print("\t");
        System.out.print("M " + getNameSurname() + " " + getSalary() + "\n");
    }

}</code></pre><p id="76ca1d89-7fe0-4dc1-94c9-90555a4cf669" class="">Officer sınıfı Employee sınıfından kalıtım alarak bu sınıftan oluşturulan nesnelerin memur olduğunu gösteren sınıftır.</p><p id="6b647e94-e34c-4920-b7c3-1f8b776f567e" class="">DIRECTOR Sınıfı</p><pre id="86827185-19ea-486d-a9ec-72b68f076498" class="code"><code>public class Director extends Employee {
    private CustomLinkedList&lt;Employee&gt; employees = new CustomLinkedList&lt;Employee&gt;();;

    public Director(String nameSurname, int salary) {
        super(nameSurname, salary);
    }

    public CustomLinkedList&lt;Employee&gt; getEmployee() {
        return employees;
    }

    public int getCost() {
        int _total = 0;
        // * altında çalışan işcilerin maaşlarının toplamı alınıyor
        for (int i = 0; i &lt; employees.size(); i++) {

            _total += employees.get(i).getCost();
        }

        // * işcilerin maaşlarının toplamına kendi maaşı da ekleniyor.
        _total += super.getCost();
        return _total;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employee.remove(employee);
    }

    public Employee getEmployee(int employeeIndex) {
        return employees.get(employeeIndex);
    }

    public CustomLinkedList&lt;Employee&gt; getChildren() {
        return employees;
    }
    
    public boolean contains(Employee emp) {
        for (int i = 0; i &lt; employees.size(); i++) {
            if (employees.get(i).getNameSurname().trim().equalsIgnoreCase(emp.getNameSurname().trim())) {
                return true;
            }
        }

        return false;
    }

    private void recursiveMetod(CustomLinkedList&lt;Employee&gt; list, int depth, boolean isCost) {
        for (int i = 0; i &lt; list.size(); i++) {
            for (int j = 0; j &lt; depth; j++) {
                System.out.print("\t");
            }
            Employee element = list.get(i);
            System.out.print("D " + element.getNameSurname() + " "
                    + ((isCost &amp;&amp; element.getClass() == Director.class) ? element.getCost() : element.getSalary())
                    + "\n");
            if (element.getClass() == Director.class) {
                Director el2 = (Director) element;
                if (el2.getChildren().size() &gt; 0) {

                    recursiveMetod(el2.getChildren(), depth + 1, isCost);
                }
            }
        }
    }

    // director ve onun emrinde çalışan işçileri yazdıran metod
    public void displayEmployeeInfo(boolean isCost) {//burdaki gelen isCost boolean'ı maaşların toplam ya da ham şeklinde yazdırılması için kullanılan bir check boolean'ıdır.
        int depth = 1;

        System.out.println(isCost ? "\nToplam maaşlar\n" : "\nHam maaşlar\n");

        System.out.println("D " + getNameSurname() + " " + (isCost ? getCost() : getSalary())); //getCost Toplam maaşları yazdırır getSalary ise işçininham maaşını yazdırır.
        recursiveMetod(employees, depth, isCost); // director altında çalışan director memur olduğu için yazdırma işleminde bir recursive metod gerekli.
    }

}</code></pre><p id="41d37cc1-8d17-4f7a-9293-49a8ac17a44e" class="">Director sınıfı Employee sınıfında kalıtım alarak bu sınıftan oluşturulan nesnelerin memurlara veya diğer direktörlerin yöneticisi konumunda olan direktörlerin oluşturulmasını sağlar.</p><p id="138f9f7a-b5f4-4d45-b25f-b12bf11eca84" class="">EmployeeComposite Sınıfı</p><pre id="e0162fcf-4793-424c-b70c-bde654438121" class="code"><code>public class EmployeeComposite {

    Employee employeeList;

    public EmployeeComposite(Employee newEmployeeList) {
        employeeList = newEmployeeList;
    }

    public void getEmployeeList() {
        employeeList.displayEmployeeInfo(false);
    }

    public Employee getEmployee() {
        return employeeList;
    }

    public static EmployeeComposite processTxtFile(String txtList) {
        // ana director
        Director rootDirector = null;
  
        String[] list = txtList.split("/");
        // root eklenyor
        String[] theRoot = null;
        // listedeki her eleman için arama yapılıyor
        for (String eleman : list) {
            String[] parameters = eleman.split(",");
            // composite design patter'ın kökü belirleniyor
            if (parameters[3].trim().equalsIgnoreCase("root")) {
                Director _director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                rootDirector = _director;
                theRoot = parameters; // örnek theRoot = ["D","NameSurname","Salary","RootName"]
            }
            // eğer köke sahipse children'ların durumu kontrol ediliyor
            else {
                if (theRoot == null) {
                    theRoot = parameters;
                }
                // eğer altında çalışan kişi bulunursa director'a ait olan employeelist'e
                // ekleniyor
                if (parameters[3].trim().equalsIgnoreCase(theRoot[1].split(" ")[0].trim())) {
                    // director ise director nesnesi ekleniyor
                    if (parameters[0].trim().equalsIgnoreCase("d")) {
                        Director _director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                        rootDirector.add(_director);

                    } else {
                        // officersa officer nesnesi ekleniyor
                        Officer _officer = new Officer(parameters[1], Integer.parseInt(parameters[2]));
                        rootDirector.add(_officer);
                    }
                    // kök ve üst seviye çocuklar elde edildikten sonra döngü kırılıyor
                } else {
                    break;
                }
            }
        }
        // rootun altındaki childrenları almak için getChildren isimli recursive metod
        // oluşturuldu.
        getChildren(rootDirector, list);
        return new EmployeeComposite(rootDirector);
    }

    private static void getChildren(Director rootDirector, String[] list) {
        // root çocuk uzunluğu
        int size = rootDirector.getChildren().size();
        // her rootun altındakiler inceleniyor
        for (int i = 0; i &lt; size; i++) {
            // Çocuğun Director olma durumu kontrol ediliyor
            if (rootDirector.getChildren().get(i).getClass() == Director.class) {
                Director element = (Director) rootDirector.getChildren().get(i);

                for (String parameter : list) {
                    String[] parameters = parameter.split(",");
                    if (element.getName().equals(parameters[3].trim())) {
                        if (parameters[0].toLowerCase().equalsIgnoreCase("d")) {
                            Director director = new Director(parameters[1], Integer.parseInt(parameters[2]));
                            element.add(director);
                            if (!element.getChildren().isEmpty()) {// directorun çocukları var yok mu kontrol ediliyor
                                getChildren(element, list);// eğer varsa directoru root yapıp onun çocuklarını aramasını
                                                           // gerçekleştiriyor
                            }

                        } else {
                            Officer officer = new Officer(parameters[1], Integer.parseInt(parameters[2]));
                            if (element.getChildren().size() == 0) {
                                element.add(officer);
                            } else {
                                if (!element.contains(officer)) {
                                    element.add(officer);
                                }

                            }

                        }

                    }
                }
            }

        }
    }
    public void getCost() {
        employeeList.displayEmployeeInfo(true);
    }

}</code></pre><p id="0a8d8b3b-a2fe-4e7b-a06c-afda7ae34304" class="">
</p><p id="6e339b09-ba6a-40c8-baee-98fa514a61c8" class="">EmployeeComposite sınıfı verilen girdileri ilk önce root yani ana direktörü (yöneticiyi) bularak sonrasında altında çalışanları aramaya başlar.</p><ul id="5e04dfc4-c6e1-4e3e-90ac-96035ea88c1f" class="bulleted-list"><li style="list-style-type:disc">Eğer altında çalışan varsa ve bu direktörse onu listeye ekler ardından son bulunan direktörün altında çalışan olup olmadığını kontrol eder<ul id="084f694d-6456-46e6-9813-56fc884a2123" class="bulleted-list"><li style="list-style-type:circle">Fakat çalışan bulamaz ise son kaldığı direktörün bir üst yönetici konumundaki direktöre dönüp başka çalışanları olup olmadığını kontrol eder.</li></ul></li></ul><ul id="3996cdb4-44f8-4c4b-871b-ec53e82c38a8" class="bulleted-list"><li style="list-style-type:disc">Eğer altında çalışan memur ise çalışan tüm memurları ekledikten sonra bir üst yöneticiye dönerek tarama işlemine devam eder.</li></ul><p id="4658ed81-fee5-42e8-bd6e-db5be97f0b03" class="">LinkedList Interface</p><pre id="f2f5153c-518b-46d6-8966-a3ce690aab6c" class="code"><code>public interface LinkedList&lt;T&gt; {

    // kullanılacak olan metodlar eklendi
    public void addNode(T data);// düğümün sonuna veri ekleme

    public void add(int index, T element);// belirli bir indexe veri ekleme

    public boolean isEmpty();// linkedlistin boş olup olmadığını kontrol etme

    public boolean add(T data);// düğümün sonuna veri eklenip eklenemeyeceğini kontrol eden metod

    public void clear();// linked listteki tüm düğümleri temizleme

    public T get(int index); // listedeki ilgili indexteki veriyi alma

    public int size(); // listenin içerisinde toplam data sayısını alma

}</code></pre><p id="cc73e799-f31f-40a0-bde7-e5be63e5a0bd" class="">Linked list için gerekli metotları implemente etmek için oluşturulan interface.</p><p id="890fa067-24ce-4b9f-b877-382acb120ca3" class="">
</p><p id="abedd02c-6889-4346-8c47-3739cbbe2797" class="">CustomLinkedList Sınıfı</p><pre id="1d1ab774-c50d-4f77-aff4-0a03143c30f1" class="code"><code>public class CustomLinkedList&lt;T&gt; implements LinkedList&lt;T&gt; {
    // inner class
    class Node&lt;T&gt; {

        private T data;// Diğer projelerle uyum sağlaması açısından T kullanıldı
        private Node&lt;T&gt; next;

        // düğüm yapısı oluşturuldu
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node&lt;T&gt; next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T newData) {
            data = newData;
        }

        public Node&lt;T&gt; getNext() {
            return next;
        }

        public void setNext(Node&lt;T&gt; newNext) {
            next = newNext;
        }

    }

    // oluşturulan düğüm yapısını linked listede kullanımı
    private Node&lt;T&gt; head = null;
    private Node&lt;T&gt; tail = null;
    private int currentSize;

    public CustomLinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public void addNode(T data) {
        Node&lt;T&gt; newNode = new Node&lt;T&gt;(data);
        // listenin boş olup olmadığını kontrol etme
        if (head == null) {
            // eğer boş ise head ve tail newNode' a point edecek
            head = newNode;
            tail = newNode;
        } else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode will become new tail of the list
            tail = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T e) {
        if (isEmpty()) {// eğer linked liste boş ise önce head düğümü oluşturulması gerekli
            head = new Node&lt;T&gt;(e, null);
            tail = head;// oluşturulan bu head tüğümü kuyruğa eklenmeli
        } else {
            // eğer ki boş değilse yeni eklenecek düğüm ilgili son kuyruğun bir sonraki
            // düğümüne eklenir
            tail.setNext(new Node&lt;T&gt;(e, null));
            tail = tail.getNext();
        }
        currentSize++;// yeni bir veri eklendiği için listenin eleman sayısı bir artırılır
        return true;
    }

    @Override
    public void clear() {// adından anlaşılacağı üzere listedeki tüm head tail gibi düğümleri bağlarını
                         // (koparmak) null a bağlıyor dolayısıyla liste tamamen temizlenmiş oluyor.
        head = null;
        tail = null;
        currentSize = 0;

    }

    @Override
    public T get(int index) {
        if (index &lt; 0 || index &gt;= size()) {
            // eğer ki index 0 dan küçük veya liste boyutuna büyük eşit olursa (ki zaten bu
            // dizi kavramına ters bir durum) bu durumda bir exception fırlatılır
            throw new IndexOutOfBoundsException();
        }

        if (index &lt; size() - 1) {
            // index listenin sonundaki elemanı almamızı istiyorsa current düğümümüz son
            // elemana kadar next yapılır ve sona varıldığında indexin istediği ilgili
            // datayı döndürür.
            Node&lt;T&gt; current = head;
            for (int i = 0; i &lt; index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
        return tail.getData();
    }

    @Override
    public void add(int index, T element) {
        if (index &lt; 0 || index &gt; size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size()) {
            add(element);
            return;
        }
        if (index == 0) {
            head = new Node&lt;T&gt;(element, head);

        } else {
            Node&lt;T&gt; current = head;
            for (int i = 0; i &lt; index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node&lt;T&gt;(element, current.getNext()));

        }
        currentSize++;

    }

    @Override
    public int size() {
        // liste boyutunu veren metod
        return currentSize;
    }

}</code></pre><p id="30cca1b6-48cc-4655-a140-0c12a0d39498" class="">CustomLinkedList sınıfı LinkedList interface’ sinden implement edilerek oluşturulmuş bir iterator desenidir. Oluşturulan hiyerarşik yapıyı dolaşmak için oluşturulmuştur. Ve bu iterator deseni çerçevesinde proje için gerekli olan koleksiyon oluşturuldu.</p><p id="acb60bf5-19c2-44b0-b75b-7af8eb70f2b5" class="">
</p><p id="5b7258d0-860f-4bd0-9f8a-1ac2e07e7e04" class="">Deneme Sınıfı</p><pre id="6d6e3a23-8c12-42d7-b203-7429c6fc553e" class="code"><code>public class Deneme {
  public static void main(String[] args) {
    String txtList = ""; // girdi texte dönüşüyoe
    try {
        File myObj = new File("../oop1/src/main/java/com/mycompany/oop1/girdi.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            txtList += data + "/";
        }

        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("Böyle bir dosya bulunamadı");
        // e.printStackTrace();
    }
    EmployeeComposite emp = EmployeeComposite.processTxtFile(txtList);

    emp.getEmployeeList();
    emp.getCost();
    
  }
}</code></pre><p id="9eeb790a-110c-431e-8c25-a2d4f3a1c0db" class="">
</p><p id="787ef113-ff3c-450f-bb92-1e3f36f4ea7a" class="">Deneme sınıfı main metodu altında oluşturulan yapının girdi.text dosyasını okuyarak ve gerekli dönüşümleri sağlayan metodlar çağıralarak+ projede istenilen şekilde çalışması sağlanmaktadır.</p><p id="e7dd1e7d-f0e6-49e6-8564-ddeb8a6d522d" class="">
</p><p id="9b5d3367-6309-44d4-b983-31f5a2750509" class="">Opp1test sınıfı junit kullanılarak bütün proje birim teste tabi tutulmuştur.</p><ul id="fae7026a-cb36-4e47-8e29-fa30f1d79300" class="bulleted-list"><li style="list-style-type:disc">DisplayEmployee metodu employee nesnelerinin null olup olmadığını kontrol eder.</li></ul><ul id="cdb9f191-dded-4c48-9136-cca5f278f406" class="bulleted-list"><li style="list-style-type:disc">CalculateSalary metotdu girilen maaş tutarlarının beklenen maaş fiyatı olup olmadığını kontrol eder.</li></ul><ul id="f9ca6462-43f3-4a23-8b52-44de409eb2d3" class="bulleted-list"><li style="list-style-type:disc">checkEmpty metodu ise oluşturulan linkedListin boş olup olmadığını kontrol eder.</li></ul></div>
