BFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return false;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;    

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++){ 
            if (indegree[i] == 0) {
                // Add the course because it has no prerequisites.
                index++; // How many courses don't need prerequisites.
                queue.offer(i);
            }
        }
         
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--; 
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course.
                        index++;
                        queue.offer(prerequisites[i][0]);
                    }
                } 
            }
        }

        return index == numCourses;
    }
}