# JPA-Spring-MVC-Test
Spring MVC Toyota Projesi için denemelerim 

# Açıklama
*Spring MVC ve JPA Kullanacağım Toyota Projesine hazırlık için yaptığım Bir denemedir.Projede Spring MVC ve JPA implementation EclipseLink
kullanılmıştır.Proje bir Maven projesidir bağımlılıkları buradan [pom.xml](https://github.com/anlrcavictor/JPA-Spring-MVC-Test/blob/master/JPASpringMVCTest2/pom.xml) inceleyebilirsiniz.*
</br>
*Birbiriyle Many-to-One İlişkide bulunan iki tablo Manufacturer ve Product tabloları kullanılmıştır.Ayrıyeten Product tablosounun eklenme
tarihi adında bir alanı vardır.Ürünler eklenirken ve tarihe göre ürünlerin listelenmesinde bir datepicker kullanılmıştır.Bu datepicker
Deneme Projenin görünümüne göre uygun ve Bootstrap Görünümlü olarak kullnaılmıştır.Bu Datepicker JavaScript kütüphanesi olan Jquery
kullanılarak 3. şahıslar tarafından yapılmıştır.*
</br></br>
![Datepicker](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/JPASpringMVC%20Test/AddProduct.png?raw=true)
</br>
*Tarih alanı input alanlarından String olarak alınmış ve içeride DateFormat ve Calendar sınıflarının format fonksiyonu kullanılarak 
formatlanmıştır.Örnek `DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");`.Bu işlemler Utility classında yapılmıştır.[İnceleyebilirsiniz.](https://github.com/anlrcavictor/JPA-Spring-MVC-Test/blob/master/JPASpringMVCTest2/src/utility/Utility.java)*
</br></br>
*Ürünler Eklenme Tarihlerine göre son iki ay da eklenenler veya kullanıcı tarafından alınan başlangıç ve bitiş tarihi aralığına göre
listelenme işlemi yapılmıştır.*
</br></br>
![ProductList](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/JPASpringMVC%20Test/ProductList.png?raw=true)
</br></br>
![ProductList2](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/JPASpringMVC%20Test/SearchProduct.png?raw=true)
</br>
*Projede güzel gözükmesi açısından Bootstrap kullanılmıştır*
</br></br>
![Manufacturers](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/JPASpringMVC%20Test/Manufacturer.png?raw=true)
</br></br>
![Product](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/JPASpringMVC%20Test/Product.png?raw=true)
</br></br>
![AddProduct](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/JPASpringMVC%20Test/AddProduct2.png?raw=true)
</br></br>
## Project Structure

![Structure](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/JPASpringMVC%20Test/Structure.png?raw=true)



