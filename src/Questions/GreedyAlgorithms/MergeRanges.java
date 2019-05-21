package Questions.GreedyAlgorithms;

import Questions.IQuestion;

import java.util.ArrayList;
import java.util.List;

public class MergeRanges implements IQuestion {
    @Override
    public void run() {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(0, 1));
        meetings.add(new Meeting(3, 5));
        meetings.add(new Meeting(4, 8));
        meetings.add(new Meeting(10, 12));
        meetings.add(new Meeting(9, 10));

        List<Meeting> mergedMeetings = mergeRanges(meetings);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Meeting m : mergedMeetings) {
            sb.append(m.toString()).append(", ");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }

    private List<Meeting> mergeRanges(List<Meeting> meetings) {

        meetings.sort((o1, o2) -> o1.startTime - o2.startTime);

        List<Meeting> mergedMeetings = new ArrayList<>();

        Meeting m = meetings.get(0);
        Meeting previous = new Meeting(m.startTime, m.endTime);
        mergedMeetings.add(previous);

        for(int i=0; i < meetings.size(); i++) {
            m = meetings.get(i);
            if (m.startTime <= previous.endTime) {
                previous.endTime = Math.max(m.endTime, previous.endTime);
            } else {
                previous = new Meeting(m.startTime, m.endTime);
                mergedMeetings.add(previous);
            }
        }

        return mergedMeetings;
    }

    private class Meeting {
        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Meeting(" + startTime + "," + endTime + ")";
        }
    }
}
