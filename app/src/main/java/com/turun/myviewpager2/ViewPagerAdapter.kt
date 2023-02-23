package com.turun.myviewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var title:List<String>,private var details:List<String>,
private var images:List<Int>):RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemV:View):RecyclerView.ViewHolder(itemV){
        val itemTitle:TextView=itemV.findViewById(R.id.tvTitle)
        val itemDetails:TextView=itemV.findViewById(R.id.tvAbout)
        val itemImage:ImageView=itemV.findViewById(R.id.ivIamge)

        init {
            itemImage.setOnClickListener { v:View->

                val position = adapterPosition  //0 dan baslar
                Toast.makeText(itemV.context,"you clicked on item ${position+1}",Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
       return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page,parent,false))

    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemTitle.text=title[position]
        holder.itemDetails.text=details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }
}
/*
Bu kod parçası, ViewPager2 bileşeninde görüntülenmek üzere özelleştirilmiş bir
 RecyclerView.Adapter sınıfı olan ViewPagerAdapter'yı içerir. Bu sınıf, her bir
  görüntülenen öğe için bir ViewHolder oluşturur ve öğe verilerini bağlar.

Sınıf, bir öğe başlığı listesi, bir öğe hakkında bilgi listesi ve bir öğe resmi
 listesi alır. onCreateViewHolder yöntemi, yeni bir ViewHolder örneği oluştururken
 inflate etmek için bir görünüm düzeni kaynağı kullanır. onBindViewHolder yöntemi,
 ViewHolder'ı belirli bir pozisyondaki verilerle bağlar.

Pager2ViewHolder iç içe sınıfı, her bir ViewHolder öğesi için bileşenleri tutar ve
 oluşturulduğunda ImageView'a bir tıklama olayı ekler. Bu olay, tıklanan öğenin
  pozisyonunu Toast mesajında gösterir.

Son olarak, getItemCount yöntemi, veri listelerinin boyutunu döndürür.

private var title:List<String>,private var details:List<String>,
private var images:List<Int>

Bu üç değişken, ViewPagerAdapter sınıfının içinde RecyclerView'da
gösterilecek olan verileri tutar. "title" değişkeni her bir öğenin
 başlığını, "details" değişkeni her bir öğenin detay bilgisini ve
 "images" değişkeni ise her bir öğenin görselini içerir. Bu değişkenler sınıfın
 içinde her yerde kullanılabilir ve adapter tarafından RecyclerView'ın
 öğelerini oluşturmak için kullanılır.


return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page,parent,false))

onCreateViewHolder fonksiyonu, verilen parent view grubuna ait bir view
holder oluşturur. Bu view holder, daha sonra onBindViewHolder fonksiyonu
tarafından verilerle doldurulur.

Burada, LayoutInflater sınıfını kullanarak item_page adlı layout dosyasından
bir view oluşturuyoruz ve bu view'ı Pager2ViewHolder sınıfımızın constructor'ına geçirerek yeni bir
view holder oluşturuyoruz. Daha sonra, oluşturduğumuz view holder'ı geri döndürüyoruz.

return title.size

return title.size satırı, adapter'in gösterdiği eleman sayısını döndürür.
 Bu durumda, title listesindeki öğelerin
 sayısı kadar eleman gösteriliyor. Bu satır adapter sınıfındaki
 getItemCount() metodu yerine kullanılıyor.
 holder.itemTitle.text=title[position]
        holder.itemDetails.text=details[position]
        holder.itemImage.setImageResource(images[position])

Bu kodlar, verilerin ViewHolder'larla eşleştirilmesini sağlar.
 onBindViewHolder() fonksiyonu, belirtilen konumdaki verileri
 alır ve verileri görsel öğelerle eşleştirir. holder nesnesi,
 RecyclerView'da belirtilen konumdaki öğeyi temsil eder. itemTitle,
  itemDetails ve itemImage,
 item_page adlı düzen dosyasındaki görüntü öğelerini temsil eder.
  Verileri bu görüntü öğelerine atarız.



   val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)
Bu kod, viewpager2 nesnesine bağlı olan CircleIndicator3 nesnesini bulur
 ve ona ViewPager2 nesnesini belirtir. Bu sayede ViewPager2'nin kaç tane
 sayfaya sahip olduğu anlaşılabilir
 ve CircleIndicator3 nesnesi sayfalar arasında geçiş yapmak için görsel
  bir gösterge sağlayabilir.


setImageResource() metodu, bir
ImageView'in kaynak olarak kullanacağı resmi
tanımlamak için kullanılır. Bu metot, bir int türünden
 drawable kaynağı alır ve ImageView'in içeriğini bu
  kaynakla değiştirir. Örneğin, aşağıdaki kod ImageView'e "my_image" adlı drawable kaynağını ekler:

scss
Copy code
val myImageView = findViewById<ImageView>(R.id.my_image_view)
myImageView.setImageResource(R.drawable.my_image)
Bu yöntem, yalnızca ImageView'lerde kullanılabilir ve
 ImageView'in kaynak özelliğini değiştirir.
 */