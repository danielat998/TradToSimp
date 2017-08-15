package TradToSimp
import DictionaryHandler.Handler
import DictionaryHandler.Word
import java.util.ArrayList
class Main{
  enum class WORD_TYPE{//TODO:put into own class and put in DictionaryHandler?
    TRADITIONAL, SIMPLIFIED, PINYIN
  }
  fun convert(val inputType:WORD_TYPE, val outputType:WORD_TYPE){
    val lines:MutableList<String> = FileUtils.fileToStringArray(fileName)
    val outputWords:MutableList<MutableList<Word>> = ArrayList<ArrayList<Word>>()
    for(line:String in lines){
      when(inputType){
        TRADITIONAL, SIMPLIFIED -> outputWords.add(stringToWordArray(inputType, line)
      }
    }

    
    val outputStrings:MutableList<String> = ArrayList<String>()
    for(line:MutableList<Word> in outputWords){
      when(outputType){
        TRADITIONAL -> ... //TODO
      }
    }
    //then do something similar for output  
    return outputLines
  }

  fun wordArrayToString(val array:MutableList<Word>, val outputType:WORD_TYPE){
    
  }

  //return array of words
  fun stringToWord(val type:WORD_TYPE, val line:String){
    val dictionaryHandler:Handler = Handler()
    val wordList:MutableList<> = ArrayList<Word>()
    for(c:Char in line.toCharArray()){
      //assume that every individual character exists in dictionary - it seems unlikely that
      //there will be a character that exists as part of a word but not independently-should be easy
      //to verify when someone has time
      val word:Word?= dictionaryHandler.getWord(from, c)
      if(word!=null){//(if word is not Chinese - seems to be mainly [。，etc])
        wordList.append(word)
      }else{
        wordList.append(NonChineseWord(c))//NonChineseWord should extend word?
      }
    }
    return wordList
  }
/*  
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
*/
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
