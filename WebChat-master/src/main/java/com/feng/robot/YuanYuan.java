package com.feng.robot;



import java.io.File;

/**
 * 机器人圆圆
 */
 
public class YuanYuan {
    private static File recordFile = new File("D:\\record.wav");
    private static String playFileName = "D:\\play.wav";
 
    public static void main1(String content){
        /**
         * 录音-->百度语音识别，获取到文本-->文本传入到图灵机器人与之对话-->拿到图灵机器人的回话
         * -->百度语音合成，将回话转为音频文件-->播放音频文件
         * 以上完成一次完整的对话
         * 若我说：退出-->百度语音识别为“退出”-->百度语音合成文本“好的，那下次再见了”-->播放音频文件-->退出程序
         * 若我说的是歌名-->播放音乐（前提是音乐已经下载好了）
         */
 
        Record record = new Record();
        SpeechRec speechRec = new SpeechRec();
        TulingRobot tulingRobot = new TulingRobot();
 
        while(true){
            record.record();//录音
            try {
                speechRec.getToken();
                String recordText = speechRec.ASR(recordFile);//百度语音识别
                if(recordText.equals("退出。")){
                    speechRec.TTS("好的，那下次再见了");
                    System.out.println("(我):退出");
                    System.out.println("(圆圆):"+"好的，那下次再见了");
                    record.play(playFileName);//播放合成的音频文件
                    System.exit(0);//退出程序
                }
                if(recordText.equals("")){
                    speechRec.TTS("你啥也不说，我如何作答呀");
                    System.out.println("(我):"+recordText);
                    System.out.println("(圆圆):"+"你啥也不说，我如何作答呀");
                    record.play(playFileName);//播放合成的音频文件
                    continue;
                }
                /**
                 *  播放音乐（可配置）
                 *  配置过程：在指定文件夹下添加下载好的音乐-->如果识别的是音乐名，播放音频文件即可
                 */
                if(recordText.equals("意外。")){
                    System.out.println("音乐播放中...");
                    record.play("F:\\music\\意外.mp3");
                    continue;
                }
                if(recordText.equals("告白之夜。")){
                    System.out.println("音乐播放中...");
                    record.play("F:\\music\\告白之夜.mp3");
                    continue;
                }
                if(recordText.equals("工资向北走。")){//百度语音识别总是将“公子”识别成“工资”，可能是我发音不对吧哈哈                   record.play("F:\\music\\公子向北走.mp3");
                    System.out.println("音乐播放中...");
                    record.play("F:\\music\\公子向北走.mp3");
                    continue;
                }//按以上格式添加配置即可
 
                String result = tulingRobot.parseJson(tulingRobot.getResult(recordText));//得到图灵机器人的回话
                speechRec.TTS(content);//百度语音合成
                System.out.println("(我):"+recordText);
                System.out.println("(圆圆):"+result);
                record.play(playFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
