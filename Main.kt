import DictionaryHandler.src.DictionaryHandler
class Main{
  fun convertToSimplified(fileName:String){
    val dictionaryHandler:DictionaryHandler = DictionaryHandler()

    val lines:List<String> = FileUtils.fileToStringArray(fileName)
    val outputLines:List<String> = ArrayList<String>()
    for(line:String in outputLines){
      val builder:FileBuilder = FileBuilder()
      for(c:char in line.toCharArray()){
        //assume that every individual character exists in dictionary
        val word:Word=getWordFromChinese(c)
        if(word!=null){
          builder.add(word)
        }else{
          builder.add(c)
        }
      }
      outputLines.add(builder.toString())
    }
  }

  fun main(args:Array<String>){
    if(args.length!=0){
      for(fileName:String in args){
      System.out.println(convertToSimplified(fileName));
    }
    }else{
      //read from standard input
    }
  }
}
