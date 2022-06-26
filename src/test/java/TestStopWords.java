import org.junit.Assert;
import org.junit.Test;
import safar.modern_standard_arabic.basic.morphology.stemmer.factory.StemmerFactory;
import safar.modern_standard_arabic.basic.morphology.stemmer.interfaces.IStemmer;
import safar.modern_standard_arabic.util.stop_words.factory.StopWordFactory;
import safar.modern_standard_arabic.util.stop_words.interfaces.ISWsService;

public class TestStopWords {

    @Test
    public void testStopWords() {

        try {
            ISWsService wsService = StopWordFactory.getSWsImplementation();
            System.out.println("starting...");
            Long t1 = System.currentTimeMillis();
            String text = " تساؤلات حول طريقة صرْف الإعانة المالية المخصصة لمؤسسة الأعمال الاجتماعية لموظفي قطاع التعليم العالي “F.O.S.E”، التي تصل إلى 200 مليون سنتيم سنويا، تتوصل بها المؤسسة من الوزارة، غير أن الموظفين يقولون إنهم لا يرون لها أثرا، إذ إن الوجبات الغذائية التي تُقدم لهم هي عبارة عن “بطاطا وخيزو”، كما يصفونها.\n" +
                    "\n" +
                    "وعلمت هسبريس من مصدر مطلع أن ملف ميزانية مؤسسة الأعمال الاجتماعية لموظفي قطاع التعليم العالي وصل إلى القضاء، إذ تقدم محامي الموظفين المشتكين بشكاية إلى الوكيل العام للملك لدى محكمة الاستئناف بالرباط، بشأن “التصرف في مال عام مخصص لصرفه على أعضاء جمعية الأعمال الاجتماعية للتعليم”، مرفوقة بلائحة أسماء وتوقيعات 108 موظفين.\n" +
                    "\n" +
                    "ويطالب موظفو مؤسسة الأعمال الاجتماعية للتعليم، فرع الإدارة المركزية للتعليم العالي والبحث العلمي وتكوين الأطر، بتمكينهم من تقرير تفصيلي عن الوضعية المالية للمؤسسة، من أجل الاطلاع عليها وأخذ فكرة شاملة عن مداخيلها ومصاريفها، والوقوف على مدى نجاعة صرْف الإعانات المقدمة لها من طرف الوزارة.";

            String[] words = text.split(" ");
            for (String word : words) {
                wsService.isStopWord(word);
            }


            long processingTime = System.currentTimeMillis() - t1;
            System.out.println(processingTime);

        } catch(Exception e) {
            Assert.fail("Should not have thrown any exception");
        }

    }
}
