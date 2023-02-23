package com.turun.myviewpager2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()
        view_pager2.adapter = ViewPagerAdapter(titleList, descList, imageList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)
        view_pager2.setCurrentItem(0, false)//kaçıncı elemandan başlayacağını gösterir

        btn_fake_swipe.setOnClickListener {
            view_pager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()


            }
        }
      /*
        view_pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // Son sayfaya geldiğinde, sıfırıncı elemana dön
                if (position == titleList.size-1 ) {
                    view_pager2.setCurrentItem(0, false)
                }
            }
        })
       */

    }


    private fun addToList(title: String, description: String, image: Int) {
        titleList.add(title)
        descList.add(description)
        imageList.add(image)
    }

    private fun postToList() {
        for (i in 1..4) {
            addToList("title$i", "description $i", R.mipmap.ic_launcher_round)
        }
    }
}

/*
   private var titleList= mutableListOf<String>()
    private var decList= mutableListOf<String>()
    private var imageList= mutableListOf<Int>()
Bu kod bloğu, titleList, decList ve imageList isimli üç tane boş değişken tanımlıyor.
Bu değişkenler, her biri ilgili özelliklerin bir listesini içerecek şekilde tasarlanmıştır.
titleList içinde filmlerin başlıklarının, decList içinde filmler hakkında açıklamaların,
imageList içinde ise filmlerin görsellerinin yer
alması beklenir. Bu listelere, daha sonra uygun veriler atanarak ViewPagerAdapter sınıfında
 kullanılabilirler.

 postToList()
        view_pager2.adapter = ViewPagerAdapter(titleList, descList, imageList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
postToList() fonksiyonu, titleList, descList ve imageList adlı mutable
 listeleri oluşturduktan sonra, bu listeleri ViewPagerAdapter sınıfının
 bir örneği olarak view_pager2 adlı ViewPager2 nesnesine atar. view_pager2
  nesnesinin yatay olarak düzenlenmesi için orientation özelliği
ViewPager2.ORIENTATION_HORIZONTAL değerine atanır. Böylece ViewPager2,
 yatay olarak sayfaları yönetir.

 mutableListOf bir koleksiyon oluşturmak için kullanılan bir işlevdir.
  Bu koleksiyon, öğeleri eklemeye, kaldırmaya veya değiştirmeye izin veren
   bir liste veri yapısıdır. mutableListOf işlevi, öğelerin türüne bağlı olarak
 farklı şekillerde kullanılabilir. Örneğin, mutableListOf<String>() bir String
  koleksiyonu oluşturacaktır.


  btn_fake_swipe.setOnClickListener {
            view_pager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }
Bu kod, "btn_fake_swipe" adlı
bir butona tıklandığında bir ViewPager2
nesnesine sahip olan "view_pager2"
değişkeninde bir "fake drag" işlemi başlatır.
 Fake drag, ViewPager'ın içeriği görüntüleme
 şeklini taklit eder ve kullanıcının herhangi
 bir dokunma hareketi yapmadan ViewPager'ın sayfaları
 arasında kaydırmasını sağlar. Bu şekilde, ViewPager'ın
  hareketiyle ilgili bir animasyon oluşturabilirsiniz.




kamuranturunn@gmail.com
  fakeDragBy(-10f)
fakeDragBy() methodu, sahte bir kaydırma işlemi
gerçekleştirir. Metoda verilen parametre, sahte
kaydırmanın ne kadarlık bir mesafe yapacağını belirler.
 Yukarıdaki kodda, -10f değeri, sahte kaydırmanın sola doğru
 10 piksel mesafe yapacağını belirtir. beginFakeDrag() ve endFakeDrag()
  metodları ise sırasıyla sahte kaydırma işleminin başlatılması ve sonlandırılması için kullanılır.



  private fun addToList(title: String, description: String, image: Int) {
        titleList.add(title)
        descList.add(description)
        imageList.add(image)

Bu fonksiyon, title, description ve image parametreleri ile çağrıldığında, her bir
 parametreyi sırasıyla titleList, descList ve imageList listelerine ekler.
Bu sayede, bu listeler daha önceden oluşturulan ViewPagerAdapter içindeki verileri
saklamak için kullanılır


view_pager2.adapter
view_pager2.adapter ViewPager2 nesnesinin adapter'ını döndürür. Bu adapter ViewPager2'nin içeriğini yönetir ve ViewPager2'ye bağlı olan herhangi bir veri kaynağından verileri çeker ve kullanıcının görüntülemesi için ekranda gösterir.





adapter
"Adapter" terimi, bir Android uygulamasında, verileri belirli bir
 veri kaynağından alan ve bu verileri, görünümleri doldurmak için
 kullanılan bir arayüzü, genellikle bir RecyclerView, ListView veya
 ViewPager gibi bir bileşenle eşleştiren bir sınıfı ifade eder.
 Adapter, verileri görüntüler ve kullanıcının bu verilerle
  etkileşime girmesine izin verir.


 private fun postToList() {
        for (i in 1..10) {
            addToList("title$i", "description $i", R.mipmap.ic_launcher_round)
        }
postToList() fonksiyonu, addToList()
fonksiyonunu kullanarak, bir for döngüsü ile titleList,
descList ve imageList listelerine 10 adet öğe ekler. Örneğin,
 i değişkeni 1'den 10'a kadar arttırılır ve addToList() fonksiyonu,
  "title1" string'i ile "description 1" string'ini ve R.mipmap.ic_launcher_round
  öğesini titleList, descList ve imageList listelerine ekler. Sonuç olarak,
   titleList, descList ve imageList listeleri, her biri 10 öğeye sahip olan
   10 adet "title", "description" ve resim öğesi içerir. Bu listeler daha sonra
    ViewPagerAdapter
 sınıfının kurucu yöntemi tarafından kullanılmak üzere ViewPagerAdapter sınıfına aktarılır.
 */