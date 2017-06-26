//@file:JvmName("Launcher")
package TradToSimp
import DictionaryHandler.Handler
import DictionaryHandler.Word
//import kotlin.String
//import java.util.List
import java.util.ArrayList
//import kotlin.collections.ArrayList
class Main{
  fun convertToSimplified(fileName:String){
    val dictionaryHandler:Handler = Handler()

    val lines:List<String>? = FileUtils.fileToStringArray(fileName)
    val outputLines:List<String> = ArrayList<String>()
    for(line:String in outputLines){
//System.out.println(line::class)
/*
      val builder:StringBuilder = StringBuilder()
      for(c:Char in line.toCharArray()){
        //assume that every individual character exists in dictionary
          val word:Word= dictionaryHandler.getWordFromChinese(c)
          if(word!=null){
            builder.append(word)
          }else{
            builder.append(c)
          }
      }
      outputLines.add(builder.toString())
*/
    }
  }
  companion object{
   @JvmStatic fun main(args: Array<String>){
     if(args.size!=0){
       for(fileName:String in args){
         System.out.println(Main().convertToSimplified(fileName));
       }
     }else{
       //read from standard input
     }
   }
  }
}
