package TradToSimp
import DictionaryHandler.Handler
import DictionaryHandler.Word
import java.util.ArrayList
class Main{
  fun convertToSimplified(fileName:String):MutableList<String>{
    val dictionaryHandler:Handler = Handler()
    val lines:MutableList<String> = FileUtils.fileToStringArray(fileName)
    val outputLines:MutableList<String> = ArrayList<String>()
    for(line:String in lines){
      val builder:StringBuilder = StringBuilder()
      for(c:Char in line.toCharArray()){
        //assume that every individual character exists in dictionary
          val word:Word?= dictionaryHandler.getWordFromChinese(c)

          if(word!=null){//(if word is not Chinese - seems to be mainly [。，etc])
            builder.append(word.getSimplifiedChinese())
          }else{
            builder.append(c)
          }
      }
      outputLines.add(builder.toString())
    }
    return outputLines
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
